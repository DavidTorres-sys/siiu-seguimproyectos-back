package com.udea.siiuseguimproyectosback.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HealthController provides a simple health check endpoint for the API.
 * This endpoint can be used to verify that the API is running and accessible.
 */
@RestController
@RequestMapping("/v1/health")
public class PingController {

    /**
     * Health check endpoint to verify that the API is running.
     *
     * @return A simple confirmation message that the API is running.
     */
    @Operation(summary = "Health Check",
            description = "Returns a simple message to indicate that the API is operational.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API is running successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("API is running", HttpStatus.OK);
    }
}
