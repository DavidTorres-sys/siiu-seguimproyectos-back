package com.udea.siiuseguimproyectosback.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Configuration class for OpenAPI documentation of the SIIU Seguimiento Proyectos API.
 * <p>
 * This class configures OpenAPI metadata, including the title, version, contact information,
 * license, and the server URL used for the API. It also defines the server URL to be used
 * for the development environment from a property in the application's configuration.
 * </p>
 */
@Configuration
public class OpenAPIConfig {

    // Injects the server URL for the development environment from application.yaml
    @Value("${siiu-seguimproyectos-api.openapi.dev-url}")
    private String devUrl;

    /**
     * Bean method to configure and expose OpenAPI metadata for the API.
     * <p>
     * This method sets the necessary information for the API documentation, including:
     * <ul>
     *   <li>Server URL in the development environment</li>
     *   <li>API information such as title, description, version, and terms of service</li>
     *   <li>Contact information for API support</li>
     *   <li>License information for the API</li>
     * </ul>
     * </p>
     *
     * @return the OpenAPI instance containing the metadata and configuration
     */
    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        String title = "SIIU Seguimiento Proyectos API";
        String description = "This API exposes the endpoints for SIIU Seguimiento Proyectos.";
        String version = "1.0";

        Contact contact = new Contact();
        contact.setEmail("desarrollo.siiu1@udea.edu.co");
        contact.setName("SIIU Seguimiento Proyectos API Support");
        contact.setUrl("https://www.udea.edu.co");

        License mitLicense = new License().name("MIT License")
                .url("https://www.siuu-seguiproyectos.com/licenses/mit/");

        Info info = new Info()
                .title(title)
                .version(version)
                .contact(contact)
                .description(description)
                .termsOfService("https://www.siuu-seguiproyectos.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(Collections.singletonList(devServer));
    }
}
