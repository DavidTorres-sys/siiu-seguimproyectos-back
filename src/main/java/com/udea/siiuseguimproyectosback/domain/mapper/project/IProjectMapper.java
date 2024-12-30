package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.entity.project.*;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IProjectMapper extends IEntityMapper<ProjectDTO, Project> {
    @Mappings({
            @Mapping(target = "selectionProcess", source = "selectionProcess.name"),
            @Mapping(target = "announcement", source = "announcement.shortName"),
            @Mapping(target = "projectSubLevel", source = "projectSubLevel.name"),
            @Mapping(target = "projectSubtype", source = "projectSubtype.projectType.name"),
    })
    ProjectDTO toDTO(Project project);

    @Mappings({
            @Mapping(target = "selectionProcess", source = "selectionProcess"),
            @Mapping(target = "announcement", source = "announcement"),
            @Mapping(target = "projectSubLevel", source = "projectSubLevel"),
            @Mapping(target = "projectSubtype", source = "projectSubtype"),
    })
    Project toEntity(ProjectDTO projectDTO);

    SelectionProcess mapSelectionProcess(String selectionProcessName);
    Announcement mapAnnouncement(String announcementShortName);
    ProjectSubLevel mapSubLevelProject(String subLevelProjectName);
    ProjectSubType mapProjectSubtype(String projectSubtypeName);
    ProjectType mapProjectType(String projectTypeName);
}
