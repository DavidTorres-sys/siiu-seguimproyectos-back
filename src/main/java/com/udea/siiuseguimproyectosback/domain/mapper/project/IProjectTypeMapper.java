package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectType;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link ProjectTypeDTO} and {@link ProjectType}.
 * <p>
 * This interface leverages MapStruct to automatically generate the implementation
 * for mapping between the Data Transfer Object (DTO) and the Entity.
 * </p>
 *
 * <p>
 * The generated implementation will be a Spring-managed bean.
 * </p>
 */
@Mapper(componentModel = "spring")
public interface IProjectTypeMapper extends IEntityMapper<ProjectTypeDTO, ProjectType> { }
