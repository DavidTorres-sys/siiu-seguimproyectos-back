package com.udea.siiuseguimproyectosback.services.project.projectType;

import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectType;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectTypeMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing {@link ProjectType} entities.
 * <p>
 * This service implements the {@link IProjectTypeService} interface, providing
 * methods to retrieve, manage, and transform {@link ProjectType} entities into {@link ProjectTypeDTO}
 * objects for external consumption. The service interacts with the {@link IProjectTypeRepository}
 * to fetch data and utilizes {@link IProjectTypeMapper} for entity-to-DTO transformations.
 * </p>
 *
 * <h3>Primary Responsibilities:</h3>
 * <ul>
 *     <li>Fetch and paginate a list of project types</li>
 *     <li>Handle validation errors and business logic exceptions</li>
 * </ul>
 *
 * @see IProjectTypeService
 * @see IProjectTypeRepository
 * @see IProjectTypeMapper
 * @see ProjectType
 * @see ProjectTypeDTO
 */
@Service
public class ProjectTypeServiceImpl implements IProjectTypeService {

    private final IProjectTypeRepository projectTypeRepository;
    private final IProjectTypeMapper projectTypeMapper;

    /**
     * Constructs the service with required dependencies.
     *
     * @param projectTypeRepository the repository for {@link ProjectType} entities
     * @param projectTypeMapper     the mapper for converting {@link ProjectType} entities to {@link ProjectTypeDTO}
     */
    @Autowired
    public ProjectTypeServiceImpl(
            IProjectTypeRepository projectTypeRepository,
            IProjectTypeMapper projectTypeMapper) {
        this.projectTypeRepository = projectTypeRepository;
        this.projectTypeMapper = projectTypeMapper;
    }

    /**
     * Retrieves a paginated list of {@link ProjectTypeDTO} entities.
     * <p>
     * This method uses pagination parameters {@code skip} and {@code limit} to fetch a subset
     * of {@link ProjectType} records. The records are then converted into DTOs for external use.
     * </p>
     *
     * <h4>Validation Rules:</h4>
     * <ul>
     *     <li>{@code skip} must be greater than or equal to 0.</li>
     *     <li>{@code limit} must be greater than 0.</li>
     * </ul>
     *
     * <h4>Exceptions:</h4>
     * <ul>
     *     <li>{@link IllegalArgumentException} - Thrown if {@code skip} or {@code limit} are invalid.</li>
     *     <li>{@link DataNotFoundException} - Thrown if no project types are found in the given range.</li>
     *     <li>{@link RuntimeException} - Thrown if an unexpected error occurs during data retrieval.</li>
     * </ul>
     *
     * @param skip  the number of records to skip (used for pagination)
     * @param limit the maximum number of records to retrieve per page
     * @return an {@link Optional} containing a list of {@link ProjectTypeDTO}.
     *         The optional is never empty if valid results are found.
     * @throws IllegalArgumentException if {@code skip} or {@code limit} are invalid
     * @throws DataNotFoundException    if no records are found
     * @throws RuntimeException         if an unknown error occurs
     */
    @Override
    public Optional<List<ProjectTypeDTO>> getAll(Integer skip, Integer limit) {
        if (skip < 0 || limit <= 0) {
            throw new IllegalArgumentException("Los valores de 'skip' y 'limit' deben ser mayores a cero.");
        }
        try {
            List<ProjectType> projectTypes = projectTypeRepository
                    .findAll(PageRequest.of(skip, limit))
                    .getContent();

            if (projectTypes.isEmpty()) {
                throw new DataNotFoundException("No se encontraron tipos de proyecto.");
            }
            return Optional.of(projectTypeMapper.toDTO(projectTypes));
        } catch (DataNotFoundException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Parámetros inválidos: skip=" + skip + " limit=" + limit);
        } catch (Exception e) {
            throw new RuntimeException("Error desconocido al intentar obtener los tipos de proyecto.", e);
        }
    }
}
