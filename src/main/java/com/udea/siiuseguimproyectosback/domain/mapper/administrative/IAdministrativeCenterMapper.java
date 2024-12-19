package com.udea.siiuseguimproyectosback.domain.mapper.administrative;

import com.udea.siiuseguimproyectosback.domain.dto.administrative.AdministrativeCenterDTO;
import com.udea.siiuseguimproyectosback.domain.entity.administrative.AdministrativeCenter;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link AdministrativeCenterDTO} and {@link AdministrativeCenter} entities.
 * <p>
 * This interface defines the contract for mapping data between a DTO (Data Transfer Object) and an entity class for
 * the administrative center domain. It extends the {@link IEntityMapper} interface, which provides basic
 * conversion methods.
 * </p>
 * <p>
 * The implementation of this interface will be generated automatically by the MapStruct library at compile time.
 * The generated implementation will be registered as a Spring Bean due to the use of the {@code @Mapper(componentModel = "spring")} annotation.
 * </p>
 *
 * @see AdministrativeCenterDTO
 * @see AdministrativeCenter
 * @see IEntityMapper
 */
@Mapper(componentModel = "spring")
public interface IAdministrativeCenterMapper extends IEntityMapper<AdministrativeCenterDTO, AdministrativeCenter> { }
