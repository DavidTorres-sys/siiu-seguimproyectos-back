package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.SubLevelProjectDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.SubLevelProject;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISubLevelProject extends IEntityMapper<SubLevelProjectDTO, SubLevelProject> {
}
