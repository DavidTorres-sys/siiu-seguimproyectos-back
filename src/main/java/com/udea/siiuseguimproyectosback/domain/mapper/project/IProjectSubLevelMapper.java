package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectSubLevelDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectSubLevel;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjectSubLevelMapper extends IEntityMapper<ProjectSubLevelDTO, ProjectSubLevel> {
}
