package com.udea.siiuseguimproyectosback.domain.mapper.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.SelectionProcessDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.SelectionProcess;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link SelectionProcess} entity and {@link SelectionProcessDTO}.
 * <p>
 * This interface uses MapStruct to generate the implementation for mapping operations,
 * such as converting entity objects to DTOs and vice versa.
 * </p>
 * <p>
 * The {@code componentModel = "spring"} parameter makes this mapper available as a Spring Bean,
 * enabling dependency injection wherever needed.
 * </p>
 *
 * <ul>
 *   <li><b>Entity to DTO Mapping:</b> Converts a {@link SelectionProcess} entity to its corresponding {@link SelectionProcessDTO}.</li>
 *   <li><b>DTO to Entity Mapping:</b> Converts a {@link SelectionProcessDTO} to its corresponding {@link SelectionProcess} entity.</li>
 * </ul>
 *
 * <p>
 * This mapper extends {@link IEntityMapper}, which provides generic mapping methods.
 * </p>
 *
 * @see SelectionProcess
 * @see SelectionProcessDTO
 * @see IEntityMapper
 */
@Mapper(componentModel = "spring")
public interface ISelectionProcessMapper extends IEntityMapper<SelectionProcessDTO, SelectionProcess> { }
