package com.udea.siiuseguimproyectosback.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for Project Type.
 * <p>
 * This class is used to transfer project type data between the client
 * and server layers. It ensures that the name field is validated
 * to meet specific size and non-blank constraints.
 * </p>
 */
@Data
public class ProjectTypeDTO {

    /**
     * The name of the project type.
     * <p>
     * Constraints:
     * - Must not be blank.
     * - Must have between 1 and 200 characters.
     * </p>
     */
    @NotBlank(message = "El nombre del tipo de proyecto no puede estar vacío.")
    @Size(min = 1, max = 200, message = "El nombre del tipo de proyecto debe tener entre 1 y 200 caracteres.")
    private String name;
}
