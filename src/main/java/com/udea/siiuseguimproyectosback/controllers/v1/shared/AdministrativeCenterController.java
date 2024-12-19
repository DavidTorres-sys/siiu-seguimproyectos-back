package com.udea.siiuseguimproyectosback.controllers.v1.shared;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.domain.dto.administrative.AdministrativeCenterDTO;
import com.udea.siiuseguimproyectosback.services.administrative.administrativeCenter.IAdministrativeCenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link AdministrativeCenterDTO} entities.
 * <p>
 * This controller exposes the API endpoints for interacting with administrative center data, such as retrieving
 * a paginated list of administrative centers.
 * </p>
 * <p>
 * The {@link AdministrativeCenterController} handles HTTP requests for the `/v1/compartido/centros-administrativos`
 * endpoint and delegates the actual service logic to the {@link IAdministrativeCenterService}.
 * </p>
 * <p>
 * The controller uses the Swagger annotations for API documentation, allowing easy understanding of available endpoints
 * and their parameters.
 * </p>
 *
 * @see IAdministrativeCenterService
 * @see AdministrativeCenterDTO
 */
@RestController
@RequestMapping("/v1/compartido")
@Tag(name = "Administrative Center Management", description = "Operations for managing Administrative Centers")
public class AdministrativeCenterController {

    private final IAdministrativeCenterService administrativeCenterService;

    /**
     * Constructs an instance of {@link AdministrativeCenterController}.
     * <p>
     * The constructor injects the {@link IAdministrativeCenterService} dependency, which is used for
     * retrieving and processing administrative center data.
     * </p>
     *
     * @param administrativeCenterService the service for managing administrative center data.
     */
    @Autowired
    public AdministrativeCenterController(IAdministrativeCenterService administrativeCenterService) {
        this.administrativeCenterService = administrativeCenterService;
    }

    @Operation(
            summary = "Retrieve a paginated list of Administrative Centers",
            description = "Fetch a list of administrative centers with pagination support.",
            tags = { "Administrative Center Management" }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Administrative Centers retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdministrativeCenterDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid pagination parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "404", description = "No Administrative Centers found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RuntimeException.class)))
    })
    @GetMapping("/centros-administrativos")
    public ResponseEntity<List<AdministrativeCenterDTO>> getAll(
            @Parameter(description = "Number of records to skip (pagination offset)", example = "0")
            @RequestParam(defaultValue = "0") Integer skip,

            @Parameter(description = "Maximum number of records to return (pagination limit)", example = "10")
            @RequestParam(defaultValue = "10") Integer limit) {;
        return administrativeCenterService.getAll(skip, limit).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
