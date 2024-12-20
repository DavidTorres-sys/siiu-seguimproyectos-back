package com.udea.siiuseguimproyectosback.services.project.selectionProcess;

import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import com.udea.siiuseguimproyectosback.domain.dto.project.SelectionProcessDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.SelectionProcess;
import com.udea.siiuseguimproyectosback.domain.mapper.project.ISelectionProcessMapper;
import com.udea.siiuseguimproyectosback.persistence.project.ISelectionProcessRepository;
import com.udea.siiuseguimproyectosback.utils.ValidateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link ISelectionProcessService} interface for managing Selection Processes.
 * <p>
 * This service provides the business logic for retrieving selection process data,
 * performing validations, and handling exceptions related to these operations.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Fetch selection processes from the repository with pagination support.</li>
 *   <li>Map entities to DTOs for response.</li>
 *   <li>Validate input parameters and handle errors gracefully.</li>
 * </ul>
 *
 * <p>
 * The service uses {@link ISelectionProcessRepository} for database interactions and
 * {@link ISelectionProcessMapper} for entity-to-DTO mapping.
 * </p>
 *
 * @see ISelectionProcessService
 * @see SelectionProcessDTO
 * @see SelectionProcess
 */
@Service
public class SelectionProcessServiceImpl implements ISelectionProcessService {

    private final ISelectionProcessRepository selectionProcessRepository;
    private final ISelectionProcessMapper selectionProcessMapper;

    /**
     * Constructs an instance of {@link SelectionProcessServiceImpl}.
     * <p>
     * This constructor injects the required dependencies for repository and mapper.
     * </p>
     *
     * @param selectionProcessRepository the repository for selection process data.
     * @param selectionProcessMapper the mapper for converting entities to DTOs.
     */
    @Autowired
    public SelectionProcessServiceImpl(ISelectionProcessRepository selectionProcessRepository,
                                       ISelectionProcessMapper selectionProcessMapper) {
        this.selectionProcessRepository = selectionProcessRepository;
        this.selectionProcessMapper = selectionProcessMapper;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation validates the pagination parameters using {@link ValidateParams},
     * retrieves the data from the repository, and maps it to DTOs. If no data is found,
     * a {@link DataNotFoundException} is thrown.
     * </p>
     *
     * @throws DataNotFoundException if no selection processes are found.
     * @throws IllegalArgumentException if invalid pagination parameters are provided.
     * @throws RuntimeException for unknown errors during data retrieval.
     */
    @Override
    public Optional<List<SelectionProcessDTO>> getAll(Integer skip, Integer limit) {
        ValidateParams.validatePaginationParams(skip, limit);
        try {
            List<SelectionProcess> selectionProcess = selectionProcessRepository
                    .findAll(PageRequest.of(skip, limit))
                    .getContent();
            if (selectionProcess.isEmpty()) {
                throw new DataNotFoundException("No se encontraron procesos de selección.");
            }
            return Optional.of(selectionProcessMapper.toDTO(selectionProcess));
        } catch (DataNotFoundException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Parámetros inválidos: skip=" + skip + " limit=" + limit);
        } catch (Exception e) {
            throw new RuntimeException("Error desconocido al intentar obtener los procesos de seleccion.", e);
        }
    }
}
