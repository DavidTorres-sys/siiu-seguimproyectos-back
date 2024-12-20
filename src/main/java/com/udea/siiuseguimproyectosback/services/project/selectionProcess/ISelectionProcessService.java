package com.udea.siiuseguimproyectosback.services.project.selectionProcess;

import com.udea.siiuseguimproyectosback.domain.dto.project.SelectionProcessDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Selection Process operations.
 * <p>
 * This interface defines the contract for service-level operations related to
 * {@link SelectionProcessDTO} entities. It provides methods for retrieving and processing
 * selection process data.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Define business logic for selection process operations.</li>
 *   <li>Abstract data retrieval and transformation into domain-specific DTOs.</li>
 * </ul>
 *
 * <p>
 * Implementations of this interface should handle any necessary validation,
 * error handling, and interaction with repository or data access layers.
 * </p>
 *
 * @see SelectionProcessDTO
 */
public interface ISelectionProcessService {

    /**
     * Retrieves a paginated list of {@link SelectionProcessDTO} entities.
     * <p>
     * This method supports pagination by allowing the caller to specify the number of
     * records to skip and the maximum number of records to return.
     * </p>
     *
     * @param skip the number of records to skip (pagination offset); must be a non-negative integer.
     * @param limit the maximum number of records to return (pagination limit); must be a positive integer.
     * @return an {@link Optional} containing the list of {@link SelectionProcessDTO} entities if found;
     *         otherwise, an empty {@link Optional}.
     * @throws IllegalArgumentException if skip is negative or limit is zero/negative.
     */
    Optional<List<SelectionProcessDTO>> getAll(Integer skip, Integer limit);

}
