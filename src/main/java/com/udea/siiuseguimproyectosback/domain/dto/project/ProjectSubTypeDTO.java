package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing a project subtype.
 * <p>
 * This class is used to transfer data about a project subtype between different layers of the application.
 * It provides a simplified representation of the project subtype, including its name and associated project type.
 * </p>
 *
 * <h3>Key Attributes:</h3>
 * <ul>
 *   <li><b>id:</b> The unique identifier of the project subtype.</li>
 *   <li><b>name:</b> The name or description of the project subtype.</li>
 *   <li><b>typeProject:</b> A {@link ProjectTypeDTO} object representing the type of the project associated with this subtype.</li>
 * </ul>
 *
 * <p>
 * The {@link ProjectSubTypeDTO} is used to represent a project subtype in a simplified format that can be easily transferred
 * between the service and controller layers, making it suitable for API responses or other forms of communication.
 * </p>
 *
 * @see lombok.Data
 * @see ProjectTypeDTO
 */
@Data
public class ProjectSubTypeDTO {
    /**
     * The unique identifier of the project subtype.
     * <p>
     * This ID is used to uniquely identify the project subtype within the system or database.
     * </p>
     */
    private Long id;

    /**
     * The name or description of the project subtype.
     * <p>
     * This field provides a user-friendly name for the project subtype, often used for display purposes.
     * </p>
     */
    private String name;

    /**
     * The type of project associated with this subtype.
     * <p>
     * This field holds a reference to a {@link ProjectTypeDTO}, which provides additional information about the type of the project
     * that this subtype belongs to.
     * </p>
     */
    private ProjectTypeDTO typeProject;
}
