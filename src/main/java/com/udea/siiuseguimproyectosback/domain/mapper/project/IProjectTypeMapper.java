package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectType;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link ProjectTypeDTO} and {@link ProjectType}.
 * <p>
 * This interface is part of the mapping layer and utilizes MapStruct to automate the
 * transformation between the {@link ProjectType} entity and its corresponding Data
 * Transfer Object (DTO), {@link ProjectTypeDTO}.
 * </p>
 *
 * <p>
 * By specifying {@code componentModel = "spring"}, the generated implementation of this
 * mapper will be a Spring-managed bean, allowing it to be injected where required in
 * the application.
 * </p>
 *
 * <p><b>Primary Purpose:</b></p>
 * <ul>
 *     <li>Convert an entity instance ({@link ProjectType}) to its DTO representation ({@link ProjectTypeDTO}).</li>
 *     <li>Convert a DTO instance back to its entity form.</li>
 * </ul>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>{@code
 * @Autowired
 * private IProjectTypeMapper projectTypeMapper;
 *
 * ProjectTypeDTO dto = projectTypeMapper.toDto(projectType);
 * ProjectType entity = projectTypeMapper.toEntity(dto);
 * }</pre>
 *
 * @see ProjectTypeDTO
 * @see ProjectType
 * @see IEntityMapper
 */
@Mapper(componentModel = "spring")
public interface IProjectTypeMapper extends IEntityMapper<ProjectTypeDTO, ProjectType> { }
