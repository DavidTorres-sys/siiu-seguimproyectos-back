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
     * Custom mappings:
     * <ul>
     *   <li>{@code selectionProcess.name} → {@code selectionProcess} (DTO)</li>
     *   <li>{@code announcement.shortName} → {@code announcement} (DTO)</li>
     *   <li>{@code projectSubLevel.name} → {@code projectSubLevel} (DTO)</li>
     *   <li>{@code projectSubtype.projectType.name} → {@code projectSubtype} (DTO)</li>
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
    @Mapping(target = "responsible", source = "responsible.id")
    ProjectDTO toDTO(Project project);

    /**
     * Maps a {@link ProjectDTO} to a {@link Project} entity.
     * <p>
     * Custom mappings:
     * <ul>
     *   <li>{@code selectionProcess} (DTO) → {@code selectionProcess} (Entity)</li>
     *   <li>{@code announcement} (DTO) → {@code announcement} (Entity)</li>
     *   <li>{@code projectSubLevel} (DTO) → {@code projectSubLevel} (Entity)</li>
     *   <li>{@code projectSubtype} (DTO) → {@code projectSubtype} (Entity)</li>
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
     * Maps a {@code selectionProcessName} to a {@link SelectionProcess} entity.
     *
     * @param selectionProcessName the name of the selection process.
     * @return a {@link SelectionProcess} entity with the specified name.
     */
    SelectionProcess mapSelectionProcess(String selectionProcessName);

    /**
     * Maps an {@code announcementShortName} to an {@link Announcement} entity.
     *
     * @param announcementShortName the short name of the announcement.
     * @return an {@link Announcement} entity with the specified short name.
     */
    Announcement mapAnnouncement(String announcementShortName);

    /**
     * Maps a {@code subLevelProjectName} to a {@link ProjectSubLevel} entity.
     *
     * @param subLevelProjectName the name of the project sub-level.
     * @return a {@link ProjectSubLevel} entity with the specified name.
     */
    ProjectSubLevel mapSubLevelProject(String subLevelProjectName);

    /**
     * Maps a {@code projectSubtypeName} to a {@link ProjectSubType} entity.
     *
     * @param projectSubtypeName the name of the project subtype.
     * @return a {@link ProjectSubType} entity with the specified name.
     */
    ProjectSubType mapProjectSubtype(String projectSubtypeName);

    /**
     * Maps a {@code projectTypeName} to a {@link ProjectType} entity.
     *
     * @param projectTypeName the name of the project type.
     * @return a {@link ProjectType} entity with the specified name.
     */
    ProjectType mapProjectType(String projectTypeName);

    Person mapPerson(String personId);
}
