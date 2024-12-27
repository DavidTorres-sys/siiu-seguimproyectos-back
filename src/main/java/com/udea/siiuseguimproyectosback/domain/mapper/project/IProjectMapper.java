package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import com.udea.siiuseguimproyectosback.domain.entity.project.SelectionProcess;
import com.udea.siiuseguimproyectosback.domain.entity.project.SubLevelProject;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IProjectMapper extends IEntityMapper<ProjectDTO, Project> {
    @Mappings({
            @Mapping(target = "selectionProcess", source = "selectionProcess.name"),
            @Mapping(target = "announcement", source = "announcement.shortName"),
            @Mapping(target = "subLevelProject", source = "subLevelProject.name")
    })
    ProjectDTO toDTO(Project project);

    @Mappings({
            @Mapping(target = "selectionProcess", source = "selectionProcess"),
            @Mapping(target = "announcement", source = "announcement"),
            @Mapping(target = "subLevelProject", source = "subLevelProject")
    })
    Project toEntity(ProjectDTO projectDTO);

    SelectionProcess mapSelectionProcess(String selectionProcessName);
    Announcement mapAnnouncement(String announcementShortName);
    SubLevelProject mapSubLevelProject(String subLevelProjectName);
}
