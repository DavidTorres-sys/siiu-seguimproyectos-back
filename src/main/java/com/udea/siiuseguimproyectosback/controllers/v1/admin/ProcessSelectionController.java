package com.udea.siiuseguimproyectosback.controllers.v1.admin;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.domain.dto.project.SelectionProcessDTO;
import com.udea.siiuseguimproyectosback.services.project.selectionProcess.ISelectionProcessService;
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
 * REST Controller for managing Process Selection operations.
 * <p>
 * This controller provides endpoints for administrators to manage
 * and retrieve process selection data, supporting paginated retrieval.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Handle HTTP requests related to process selection management.</li>
 *   <li>Communicate with the service layer for business logic.</li>
 *   <li>Return appropriate HTTP responses based on service layer output.</li>
 * </ul>
 *
 * <p>
 * This controller is tagged with "Process selection Management" for API documentation purposes.
 * </p>
 *
 * @see ISelectionProcessService
 * @see SelectionProcessDTO
 */
@RestController
@RequestMapping("/v1/administrador")
@Tag(name = "Process selection Management", description = "Operations for managing process selection")
public class ProcessSelectionController {

    private final ISelectionProcessService selectionProcessService;

    /**
     * Constructs an instance of {@link ProcessSelectionController}.
     * <p>
     * This constructor injects the {@link ISelectionProcessService} for handling
     * business logic related to process selection.
     * </p>
     *
     * @param processSelectionService the service for managing process selections.
     */
    @Autowired
    public ProcessSelectionController(ISelectionProcessService processSelectionService) {
        this.selectionProcessService = processSelectionService;
    }

    /**
     * Endpoint to retrieve a paginated list of process selections.
     * <p>
     * This endpoint fetches a list of process selections based on the provided pagination parameters.
     * If no process selections are found, a 404 response is returned.
     * </p>
     *
     * <p><b>API Documentation:</b></p>
     * <ul>
     *   <li><b>Path:</b> <code>/filtro-proceso-seleccion</code></li>
     *   <li><b>Method:</b> <code>GET</code></li>
     *   <li><b>Response Codes:</b>
     *       <ul>
     *           <li><code>200</code>: List of process selections retrieved successfully.</li>
     *           <li><code>400</code>: Invalid pagination parameters provided.</li>
     *           <li><code>404</code>: No process selections found.</li>
     *           <li><code>500</code>: Internal server error occurred.</li>
     *       </ul>
     *   </li>
     * </ul>
     *
     * @param skip the number of records to skip (pagination offset), default is 0.
     * @param limit the maximum number of records to return (pagination limit), default is 10.
     * @return a paginated list of {@link SelectionProcessDTO}, or an appropriate HTTP error response.
     */
    @Operation(
            summary = "Retrieve a paginated list of process selection",
            description = "Fetch a list of process selection with pagination support.",
            tags = { "Process selection Management" }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Process Selections retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SelectionProcessDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid pagination parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "404", description = "No Process Selections found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RuntimeException.class)))
    })
    @GetMapping("/filtro-proceso-seleccion")
    public ResponseEntity<List<SelectionProcessDTO>> getAll(
            @Parameter(description = "Number of records to skip (pagination offset)", example = "0")
            @RequestParam(defaultValue = "0") Integer skip,

            @Parameter(description = "Maximum number of records to return (pagination limit)", example = "10")
            @RequestParam(defaultValue = "10") Integer limit) {
        return this.selectionProcessService.getAll(skip, limit).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
