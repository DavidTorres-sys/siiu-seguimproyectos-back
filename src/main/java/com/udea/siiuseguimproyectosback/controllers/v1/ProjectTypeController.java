package com.udea.siiuseguimproyectosback.controllers.v1;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectTypeDTO;
import com.udea.siiuseguimproyectosback.services.projectType.IProjectTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for managing Project Types.
 * <p>
 * This controller provides an endpoint to retrieve paginated project types
 * and interacts with the {@link IProjectTypeService} to fetch data.
 * </p>
 *
 * <h3>Base URL:</h3>
 * {@code /v1/project-type}
 *
 * @see IProjectTypeService
 * @see ProjectTypeDTO
 */
@RestController
@RequestMapping("/v1/project-type")
@Tag(name = "Project Type Management", description = "Operations for managing Project Types")
public class ProjectTypeController {

    private final IProjectTypeService projectTypeService;

    /**
     * Constructor for ProjectTypeController.
     *
     * @param projectTypeService the service handling the business logic for Project Types
     */
    @Autowired
    public ProjectTypeController(IProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    /**
     * Retrieves a paginated list of Project Types.
     * <p>
     * This endpoint allows clients to retrieve project types using pagination.
     * The parameters {@code skip} and {@code limit} control the pagination.
     * If no values are provided, default values are used.
     * </p>
     *
     * @param skip  the number of records to skip (default = 0)
     * @param limit the maximum number of records to return (default = 10)
     * @return a {@link ResponseEntity} containing a list of {@link ProjectTypeDTO}
     */
    @GetMapping("/")
    @Operation(summary = "Get paginated project types",
            description = "Fetches project types using pagination with optional parameters for skip and limit.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of project types"),
            @ApiResponse(responseCode = "404", description = "No project types found"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters provided"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<ProjectTypeDTO>> getAllProjectTypes(
            @Parameter(description = "Number of records to skip (pagination offset)", example = "0", required = false)
            @RequestParam(defaultValue = "0") Integer skip,

            @Parameter(description = "Maximum number of records to return (pagination limit)", example = "10", required = false)
            @RequestParam(defaultValue = "10") Integer limit) {

        Optional<List<ProjectTypeDTO>> projectTypes = projectTypeService.getAll(skip, limit);

        return projectTypes.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
