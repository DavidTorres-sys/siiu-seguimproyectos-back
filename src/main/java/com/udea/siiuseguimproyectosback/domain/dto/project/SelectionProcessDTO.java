package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing a Selection Process.
 * <p>
 * This class is used to encapsulate the data for selection processes
 * that will be transferred between different layers of the application,
 * such as controllers, services, and clients.
 * </p>
 *
 * <p>
 * The {@code SelectionProcessDTO} contains the minimal and relevant
 * details about a selection process, making it lightweight and suitable
 * for external exposure.
 * </p>
 *
 * <p>
 * This class is managed using the Lombok library to reduce boilerplate
 * code, such as getters, setters, and constructors.
 * </p>
 *
 * @see lombok.Data
 */
@Data
public class SelectionProcessDTO {

        /**
         * Unique identifier of the selection process.
         */
        private Long id;

        /**
         * Name or title of the selection process.
         */
        private String name;
}
