package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectParticipantRolDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipantRol;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjectParticipantRolMapper extends IEntityMapper<ProjectParticipantRolDTO, ProjectParticipantRol> {
}
