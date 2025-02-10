package com.udea.siiuseguimproyectosback.domain.mapper;

import java.util.List;
import java.util.Set;

/**
 * Interface for mapping between Data Transfer Objects (DTOs) and Entities.
 *
 * This interface defines the contract for conversion operations between
 * DTOs and their corresponding entities, facilitating the transfer of data
 * between different layers of the application. Implementations of this
 * interface will provide the actual mapping logic.
 *
 * @param <D>   the type of the Data Transfer Object
 * @param <E> the type of the Entity
 */
public interface IEntityMapper<D, E> {

    /**
     * Converts an entity to its corresponding DTO.
     *
     * @param entity the entity to convert
     * @return the converted DTO
     */
    D toDTO(E entity);

    /**
     * Converts a DTO to its corresponding entity.
     *
     * @param dto the DTO to convert
     * @return the converted entity
     */
    E toEntity(D dto);

    /**
     * Converts a list of DTOs to a list of entities.
     *
     * @param dtoList the list of DTOs to convert
     * @return the list of converted entities
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * Converts a list of entities to a list of DTOs.
     *
     * @param entityList the list of entities to convert
     * @return the list of converted DTOs
     */
    List<D> toDTO(List<E> entityList);

    /**
     * Converts a set of DTOs to a set of entities.
     *
     * @param dtoList the set of DTOs to convert
     * @return the set of converted entities
     */
    Set<E> toEntity(Set<D> dtoList);

    /**
     * Converts a set of entities to a set of DTOs.
     *
     * @param entityList the set of entities to convert
     * @return the set of converted DTOs
     */
    Set<D> toDTO(Set<E> entityList);
}