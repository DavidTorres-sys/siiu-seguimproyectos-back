package com.udea.siiuseguimproyectosback.services.administrative.administrativeCenter;

import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import com.udea.siiuseguimproyectosback.domain.dto.administrative.AdministrativeCenterDTO;
import com.udea.siiuseguimproyectosback.domain.entity.administrative.AdministrativeCenter;
import com.udea.siiuseguimproyectosback.domain.mapper.administrative.IAdministrativeCenterMapper;
import com.udea.siiuseguimproyectosback.persistence.administrative.IAdministrativeCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link IAdministrativeCenterService} interface for handling business logic
 * related to {@link AdministrativeCenterDTO} entities.
 * <p>
 * This service provides the logic to retrieve a paginated list of administrative centers from the
 * data source and convert them into {@link AdministrativeCenterDTO} objects using MapStruct.
 * </p>
 * <p>
 * The service is responsible for handling exceptions related to invalid parameters, data not found,
 * and any unexpected runtime issues.
 * </p>
 *
 * @see IAdministrativeCenterService
 * @see AdministrativeCenterDTO
 * @see AdministrativeCenter
 * @see IAdministrativeCenterMapper
 * @see IAdministrativeCenterRepository
 */
@Service
public class AdministrativeCenterServiceImpl implements IAdministrativeCenterService {

    private final IAdministrativeCenterRepository administrativeCenterRepository;
    private final IAdministrativeCenterMapper administrativeCenterMapper;

    /**
     * Constructs an instance of {@link AdministrativeCenterServiceImpl}.
     * <p>
     * The constructor injects the repository and mapper dependencies, which are used for data retrieval
     * and data transformation, respectively.
     * </p>
     *
     * @param administrativeCenterRepository the repository to interact with the data source.
     * @param administrativeCenterMapper the mapper to convert entities to DTOs.
     */
    @Autowired
    public AdministrativeCenterServiceImpl(
            IAdministrativeCenterRepository administrativeCenterRepository,
            IAdministrativeCenterMapper administrativeCenterMapper) {
        this.administrativeCenterRepository = administrativeCenterRepository;
        this.administrativeCenterMapper = administrativeCenterMapper;
    }

    /**
     * Retrieves a paginated list of {@link AdministrativeCenterDTO} objects.
     * <p>
     * This method validates the pagination parameters, constructs a {@link PageRequest},
     * retrieves a list of {@link AdministrativeCenter} entities from the repository,
     * and converts them into a list of {@link AdministrativeCenterDTO} objects using the mapper.
     * </p>
     * <p>
     * If the parameters are invalid, an {@link IllegalArgumentException} is thrown.
     * If no results are found, a {@link DataNotFoundException} is thrown.
     * Other unexpected errors are wrapped into a {@link RuntimeException}.
     * </p>
     *
     * @param skip the number of records to skip (for pagination).
     * @param limit the maximum number of records to return (for pagination).
     * @return an {@link Optional} containing a list of {@link AdministrativeCenterDTO} objects,
     *         or an empty {@link Optional} if no results are found.
     * @throws IllegalArgumentException if the skip or limit values are invalid.
     * @throws DataNotFoundException if no administrative centers are found in the specified range.
     * @throws RuntimeException if an unexpected error occurs during the operation.
     */
    @Override
    public Optional<List<AdministrativeCenterDTO>> getAll(Integer skip, Integer limit) {

        if (skip < 0 || limit <= 0) {
            throw new IllegalArgumentException("Los valores de 'skip' y 'limit' deben ser mayores a cero.");
        }
        try {
            List<AdministrativeCenter> administrativeCenters = administrativeCenterRepository
                    .findAll(PageRequest.of(skip, limit))
                    .getContent();

            if(administrativeCenters.isEmpty()) {
                throw new DataNotFoundException("No se encontraron centros administrativos en el rango especificado.");
            }
            return Optional.of(administrativeCenterMapper.toDTO(administrativeCenters));
        } catch (DataNotFoundException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Parámetros inválidos: skip=" + skip + " limit=" + limit);
        } catch (Exception e) {
            throw new RuntimeException("Error desconocido al intentar obtener los centros administrativos.", e);
        }
    }
}
