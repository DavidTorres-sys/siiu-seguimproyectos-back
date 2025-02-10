package com.udea.siiuseguimproyectosback.services.administrative.administrativeCenter;

import com.udea.siiuseguimproyectosback.domain.dto.administrative.AdministrativeCenterDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link AdministrativeCenterDTO} data.
 * <p>
 * This interface defines the contract for the service layer responsible for handling operations related to the
 * {@link AdministrativeCenterDTO}, such as fetching data from a data source and applying business logic.
 * </p>
 * <p>
 * The service layer typically coordinates between the repository (for database access) and the mapping layer (for
 * converting between entities and DTOs).
 * </p>
 * <p>
 * The implementation of this interface is expected to manage the retrieval and handling of the data associated
 * with administrative centers.
 * </p>
 *
 * @see AdministrativeCenterDTO
 */
public interface IAdministrativeCenterService {

    /**
     * Retrieves a paginated list of {@link AdministrativeCenterDTO}.
     * <p>
     * This method fetches a list of {@link AdministrativeCenterDTO} objects with pagination support, allowing for
     * efficient querying of a large dataset. The results are returned as an {@link Optional} containing a list.
     * </p>
     *
     * @param skip  the number of records to skip (for pagination).
     * @param limit the maximum number of records to return (for pagination).
     * @return an {@link Optional} containing a list of {@link AdministrativeCenterDTO},
     *         or an empty {@link Optional} if no results are found.
     */
    Optional<List<AdministrativeCenterDTO>> getAll(Integer skip, Integer limit);
}
