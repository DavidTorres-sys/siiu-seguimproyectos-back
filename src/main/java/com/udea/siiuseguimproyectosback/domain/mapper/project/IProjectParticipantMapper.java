package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipant;
import com.udea.siiuseguimproyectosback.domain.entity.user.Person;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProjectParticipantMapper extends IEntityMapper<ProjectParticipantDTO, ProjectParticipant> {

    @Mapping(target = "project", source = "project.code")
    @Mapping(target = "responsible", expression = "java(projectParticipant.getResponsible().getFirstName() + \"\" + projectParticipant.getResponsible().getLastName1())")
    ProjectParticipantDTO toDTO(ProjectParticipant projectParticipant);

    @Mapping(target = "project", source = "project")
    @Mapping(target = "responsible", source = "responsible")
    ProjectParticipant toEntity(ProjectParticipantDTO projectParticipantDTO);

    Person mapPerson(String personName);

    Project mapProject(String projectCode);

}
