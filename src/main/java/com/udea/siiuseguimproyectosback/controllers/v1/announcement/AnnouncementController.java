package com.udea.siiuseguimproyectosback.controllers.v1.announcement;

import com.udea.siiuseguimproyectosback.core.common.StandardResponse;
import com.udea.siiuseguimproyectosback.domain.dto.announcement.AnnouncementDTO;
import com.udea.siiuseguimproyectosback.services.announcement.announcement.IAnnouncementService;
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
 * REST controller for managing {@link AnnouncementDTO} entities.
 * <p>
 * This controller exposes API endpoints for interacting with announcements, including retrieving
 * a paginated list of announcements.
 * </p>
 * <p>
 * The {@link AnnouncementController} handles HTTP requests for the `/v1/convocatoria/lista-convocatorias`
 * endpoint and delegates the actual service logic to the {@link IAnnouncementService}.
 * </p>
 * <p>
 * Swagger annotations are included for comprehensive API documentation, facilitating a clear understanding
 * of the available endpoints and their parameters.
 * </p>
 *
 * @see IAnnouncementService
 * @see AnnouncementDTO
 */
@RestController
@RequestMapping("/v1/convocatoria")
@Tag(name = "Announcement Management", description = "Operations for managing Announcements")
public class AnnouncementController {

    private final IAnnouncementService announcementService;

    /**
     * Constructor for {@link AnnouncementController}.
     * <p>
     * The constructor injects the {@link IAnnouncementService} dependency for handling
     * the business logic related to announcements.
     * </p>
     *
     * @param announcementService the service responsible for announcement management.
     */
    @Autowired
    public AnnouncementController(IAnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    /**
     * Retrieves a paginated list of announcements (convocatorias).
     * <p>
     * This endpoint allows clients to fetch announcements with pagination. The parameters {@code skip} and
     * {@code limit} control the pagination, with default values applied if omitted.
     * </p>
     *
     * <h3>Endpoint Details:</h3>
     * <ul>
     *   <li><b>URL:</b> {@code /lista-convocatorias}</li>
     *   <li><b>Method:</b> GET</li>
     *   <li><b>Parameters:</b>
     *     <ul>
     *       <li>{@code skip} (optional, default=0): Number of records to skip (pagination offset).</li>
     *       <li>{@code limit} (optional, default=10): Maximum number of records to return.</li>
     *     </ul>
     *   </li>
     *   <li><b>Responses:</b>
     *     <ul>
     *       <li>{@code 200}: List of announcements retrieved successfully.</li>
     *       <li>{@code 400}: Invalid pagination parameters.</li>
     *       <li>{@code 204}: No announcements found.</li>
     *       <li>{@code 500}: Internal server error.</li>
     *     </ul>
     *   </li>
     * </ul>
     *
     * @param skip  the number of records to skip (default = 0).
     * @param limit the maximum number of records to return (default = 10).
     * @return a {@link ResponseEntity} containing a list of {@link AnnouncementDTO} or an appropriate HTTP error response.
     */
    @Operation(
            summary = "Retrieve a paginated list of Announcements (Convocatorias)",
            description = "Fetch a list of announcements (convocatorias) with pagination support.",
            tags = { "Announcement Management" }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of announcements retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AnnouncementDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid pagination parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "204", description = "No announcements found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RuntimeException.class)))
    })
    @GetMapping("/lista-convocatorias")
    public ResponseEntity<List<AnnouncementDTO>> getAll(
            @Parameter(description = "Number of records to skip (pagination offset)", example = "0")
            @RequestParam(defaultValue = "0") Integer skip,

            @Parameter(description = "Maximum number of records to return (pagination limit)", example = "10")
            @RequestParam(defaultValue = "10") Integer limit) {

        return announcementService.getAll(skip, limit).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
