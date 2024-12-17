package com.udea.siiuseguimproyectosback.controllers.v1;

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
public class HealthController {

    /**
     * Health check endpoint to verify that the API is running.
     *
     * @return A simple confirmation message that the API is running.
     */
    @GetMapping("/")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("API is running", HttpStatus.OK);
    }
}