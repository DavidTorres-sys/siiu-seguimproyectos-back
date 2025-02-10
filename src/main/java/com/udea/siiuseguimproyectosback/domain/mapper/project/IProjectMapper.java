package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.entity.project.*;
import com.udea.siiuseguimproyectosback.domain.entity.user.Person;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface for converting between {@link Project} entities and {@link ProjectDTO} objects.
 * <p>
 * This interface uses MapStruct to automatically generate implementations for mapping logic at runtime.
 * It defines custom mappings for nested objects and complex fields to ensure accurate transformation
 * between entity and DTO representations.
 * </p>
 *
 * <h3>Key Features:</h3>
 * <ul>
 *   <li><b>Entity to DTO Mapping:</b> Transforms a {@link Project} entity into a {@link ProjectDTO} object.</li>
 *   <li><b>DTO to Entity Mapping:</b> Transforms a {@link ProjectDTO} object back into a {@link Project} entity.</li>
 *   <li><b>Custom Nested Mapping:</b> Maps specific fields from nested objects (e.g., {@code selectionProcess.name}) to simplify the DTO structure.</li>
 *   <li><b>Helper Methods:</b> Includes methods to map individual fields like {@link SelectionProcess} and {@link Announcement} from simple strings.</li>
 * </ul>
 *
 * <p>
 * The generated mapper is a Spring-managed component, making it easy to inject into services or controllers.
 * </p>
 *
 * @see Project
 * @see ProjectDTO
 * @see IEntityMapper
 */
@Mapper(componentModel = "spring")
public interface IProjectMapper extends IEntityMapper<ProjectDTO, Project> {

    /**
     * Maps a {@link Project} entity to a {@link ProjectDTO}.
     * <p>
     * This method maps specific fields from nested objects and formats names into simplified DTO properties.
     * Custom mappings include:
     * <ul>
     *   <li>{@code selectionProcess.name} → {@code selectionProcess} (DTO)</li>
     *   <li>{@code announcement.shortName} → {@code announcement} (DTO)</li>
     *   <li>{@code projectSubLevel.name} → {@code projectSubLevel} (DTO)</li>
     *   <li>{@code projectSubtype.projectType.name} → {@code projectSubtype} (DTO)</li>
     *   <li>{@code getResponsibleName(project)} → {@code responsible} (DTO)</li>
     *   <li>{@code getIpCoordinatorName(project)} → {@code ipCoordinator} (DTO)</li>
     * </ul>
     * </p>
     *
     * @param project the {@link Project} entity to be converted.
     * @return the mapped {@link ProjectDTO}.
     */
    @Mapping(target = "selectionProcess", source = "selectionProcess.name")
    @Mapping(target = "announcement", source = "announcement.shortName")
    @Mapping(target = "projectSubLevel", source = "projectSubLevel.name")
    @Mapping(target = "projectSubtype", source = "projectSubtype.projectType.name")
    @Mapping(target = "responsible", expression = "java(getResponsibleName(project))")
    @Mapping(target = "ipCoordinator", expression = "java(getIpCoordinatorName(project))")
    ProjectDTO toDTO(Project project);

    /**
     * Maps a {@link ProjectDTO} to a {@link Project} entity.
     * <p>
     * This method reverses the conversion from DTO to Entity, mapping DTO properties back to their corresponding
     * fields in the {@link Project} entity. Custom mappings include:
     * <ul>
     *   <li>{@code selectionProcess} (DTO) → {@code selectionProcess} (Entity)</li>
     *   <li>{@code announcement} (DTO) → {@code announcement} (Entity)</li>
     *   <li>{@code projectSubLevel} (DTO) → {@code projectSubLevel} (Entity)</li>
     *   <li>{@code projectSubtype} (DTO) → {@code projectSubtype} (Entity)</li>
     *   <li>{@code responsible} (DTO) → {@code responsible} (Entity)</li>
     * </ul>
     * </p>
     *
     * @param projectDTO the {@link ProjectDTO} to be converted.
     * @return the mapped {@link Project} entity.
     */
    @Mapping(target = "selectionProcess", source = "selectionProcess")
    @Mapping(target = "announcement", source = "announcement")
    @Mapping(target = "projectSubLevel", source = "projectSubLevel")
    @Mapping(target = "projectSubtype", source = "projectSubtype")
    @Mapping(target = "responsible", source = "responsible")
    Project toEntity(ProjectDTO projectDTO);

    /**
     * Retrieves the full name of the responsible person for a project.
     * <p>
     * This method concatenates the first and last names of the responsible person to provide a full name.
     * It handles the case where the responsible person may be null.
     * </p>
     *
     * @param project the {@link Project} entity.
     * @return the full name of the responsible person, or null if not available.
     */
    default String getResponsibleName(Project project) {
        if (project.getResponsible() != null) {
            return project.getResponsible().getFirstName() + project.getResponsible().getLastName1();
        }
        return null;
    }

    /**
     * Retrieves the full name of the IP Coordinator for the project.
     * <p>
     * This method looks through the project's participants and returns the full name of the first participant
     * who has a responsible person. It handles cases where participants or responsible persons might be null.
     * </p>
     *
     * @param project the {@link Project} entity.
     * @return the full name of the IP Coordinator, or null if not available.
     */
    default String getIpCoordinatorName(Project project) {
        if (project.getParticipants() != null) {
            return project
                    .getParticipants()
                    .stream()
                    .filter(participant -> participant.getResponsible() != null)
                    .map(participant ->
                            participant.getResponsible().getFirstName() + participant.getResponsible().getLastName1())
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Maps a {@code selectionProcessName} to a {@link SelectionProcess} entity.
     * <p>
     * This method maps the name of the selection process to its corresponding {@link SelectionProcess} entity.
     * </p>
     *
     * @param selectionProcessName the name of the selection process.
     * @return a {@link SelectionProcess} entity with the specified name.
     */
    SelectionProcess mapSelectionProcess(String selectionProcessName);

    /**
     * Maps an {@code announcementShortName} to an {@link Announcement} entity.
     * <p>
     * This method maps the short name of an announcement to its corresponding {@link Announcement} entity.
     * </p>
     *
     * @param announcementShortName the short name of the announcement.
     * @return an {@link Announcement} entity with the specified short name.
     */
    Announcement mapAnnouncement(String announcementShortName);

    /**
     * Maps a {@code subLevelProjectName} to a {@link ProjectSubLevel} entity.
     * <p>
     * This method maps the name of a project sub-level to its corresponding {@link ProjectSubLevel} entity.
     * </p>
     *
     * @param subLevelProjectName the name of the project sub-level.
     * @return a {@link ProjectSubLevel} entity with the specified name.
     */
    ProjectSubLevel mapSubLevelProject(String subLevelProjectName);

    /**
     * Maps a {@code projectSubtypeName} to a {@link ProjectSubType} entity.
     * <p>
     * This method maps the name of a project subtype to its corresponding {@link ProjectSubType} entity.
     * </p>
     *
     * @param projectSubtypeName the name of the project subtype.
     * @return a {@link ProjectSubType} entity with the specified name.
     */
    ProjectSubType mapProjectSubtype(String projectSubtypeName);

    /**
     * Maps a {@code projectTypeName} to a {@link ProjectType} entity.
     * <p>
     * This method maps the name of a project type to its corresponding {@link ProjectType} entity.
     * </p>
     *
     * @param projectTypeName the name of the project type.
     * @return a {@link ProjectType} entity with the specified name.
     */
    ProjectType mapProjectType(String projectTypeName);

    /**
     * Maps a {@code personName} to a {@link Person} entity.
     * <p>
     * This method maps a person's name to a {@link Person} entity.
     * </p>
     *
     * @param personName the name of the person.
     * @return a {@link Person} entity with the specified name.
     */
    Person mapPerson(String personName);
}
