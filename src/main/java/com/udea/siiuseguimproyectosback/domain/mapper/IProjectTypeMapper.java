package com.udea.siiuseguimproyectosback.domain.mapper;

import com.udea.siiuseguimproyectosback.domain.dto.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.ProjectType;
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
