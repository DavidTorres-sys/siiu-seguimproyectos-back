package com.udea.siiuseguimproyectosback.domain.dto.administrative;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for Administrative Center.
 * <p>
 * This class is used to transfer administrative center data between the client
 * and server layers. It includes validation constraints to ensure data integrity.
 * </p>
 */

@Data
public class AdministrativeCenterDTO {

    /**
     * The unique identifier for the administrative center.
     * <ul>
     *   <li>This field represents the primary key of the Administrative Center entity.</li>
     *   <li>It is auto-generated by the database upon creation of a new record.</li>
     *   <li>It is included in the DTO to allow referencing and operations such as updates and deletes.</li>
     * </ul>
     * Constraints:
     * <ul>
     *   <li>Cannot be null when updating an existing administrative center.</li>
     * </ul>
     */
    @NotNull(message = "El identificador del centro administrativo no puede ser nulo.")
    private Long id;

    /**
     * The short name of the administrative center.
     * <p>
     * Constraints:
     * <ul>
     *   <li>Must not be null.</li>
     *   <li>Must have between 1 and 60 characters.</li>
     * </ul>
     * </p>
     */
    @NotNull(message = "El nombre del centro administrativo no puede ser nulo.")
    private String shortName;
}
