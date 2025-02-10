package com.udea.siiuseguimproyectosback.services.project.projectType;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectType;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link ProjectTypeDTO} entities.
 * <p>
 * This interface defines the methods for interacting with {@link ProjectType} entities
 * in the service layer. The implementation of this service is expected to handle business
 * logic and data transformations before returning the DTOs to the controller.
 * </p>
 */
public interface IProjectTypeService {

    /**
     * Retrieves a paginated list of {@link ProjectTypeDTO} entities.
     * <p>
     * This method fetches a subset of project types based on the given skip and limit values
     * to support pagination of the results.
     * </p>
     *
     * @param skip the number of records to skip (for pagination).
     * @param limit the maximum number of records to return.
     * @return an {@link Optional} containing a list of {@link ProjectTypeDTO} entities, or an empty {@link Optional}
     *         if no results are found.
     */
    Optional<List<ProjectTypeDTO>> getAll(Integer skip, Integer limit);
}
