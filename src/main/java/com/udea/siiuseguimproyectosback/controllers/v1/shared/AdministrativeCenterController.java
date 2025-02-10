package com.udea.siiuseguimproyectosback.controllers.v1.shared;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.domain.dto.administrative.AdministrativeCenterDTO;
import com.udea.siiuseguimproyectosback.services.administrative.administrativeCenter.IAdministrativeCenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing {@link AdministrativeCenterDTO} entities.
 * <p>
 * This controller provides API endpoints for interacting with administrative center data,
 * including retrieving a paginated list of administrative centers.
 * </p>
 * <p>
 * The controller maps requests for the `/v1/compartido/centros-administrativos` endpoint and
 * delegates service logic to the {@link IAdministrativeCenterService}.
 * </p>
 * <p>
 * Swagger annotations are included for API documentation, facilitating easy comprehension
 * of available endpoints and their parameters.
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
     * Constructor for {@link AdministrativeCenterController}.
     * <p>
     * Injects the {@link IAdministrativeCenterService} dependency for handling
     * administrative center data operations.
     * </p>
     *
     * @param administrativeCenterService the service for administrative center management.
     */
    @Autowired
    public AdministrativeCenterController(IAdministrativeCenterService administrativeCenterService) {
        this.administrativeCenterService = administrativeCenterService;
    }

    /**
     * Retrieves a paginated list of Administrative Centers.
     * <p>
     * This endpoint allows clients to fetch administrative centers with pagination. The parameters
     * {@code skip} and {@code limit} control the pagination, with default values applied if omitted.
     * </p>
     *
     * <h3>Endpoint Details:</h3>
     * <ul>
     *   <li><b>URL:</b> {@code /centros-administrativos}</li>
     *   <li><b>Method:</b> GET</li>
     *   <li><b>Parameters:</b>
     *     <ul>
     *       <li>{@code skip} (optional, default=0): Number of records to skip (pagination offset).</li>
     *       <li>{@code limit} (optional, default=10): Maximum number of records to return.</li>
     *     </ul>
     *   </li>
     *   <li><b>Responses:</b>
     *     <ul>
     *       <li>{@code 200}: List of Administrative Centers retrieved successfully.</li>
     *       <li>{@code 400}: Invalid pagination parameters.</li>
     *       <li>{@code 404}: No Administrative Centers found.</li>
     *       <li>{@code 500}: Internal server error.</li>
     *     </ul>
     *   </li>
     * </ul>
     *
     * @param skip  the number of records to skip (default = 0).
     * @param limit the maximum number of records to return (default = 10).
     * @return a {@link ResponseEntity} containing a list of {@link AdministrativeCenterDTO} or an appropriate HTTP error response.
     */
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
            @RequestParam(defaultValue = "10") Integer limit) {
        return administrativeCenterService.getAll(skip, limit).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
