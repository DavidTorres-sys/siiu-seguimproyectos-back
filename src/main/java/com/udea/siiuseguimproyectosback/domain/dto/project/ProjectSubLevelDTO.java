package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing a project sub-level.
 * <p>
 * This class is used to transfer data about a project sub-level between different layers of the application.
 * It provides a simplified view of the sub-level project entity, containing only the essential information required for communication.
 * </p>
 *
 * <h3>Key Attributes:</h3>
 * <ul>
 *   <li><b>id:</b> The unique identifier of the sub-level project.</li>
 *   <li><b>subLevelProject:</b> The ID or code representing the sub-level project within a larger hierarchy or structure.</li>
 *   <li><b>name:</b> The name or description of the sub-level project.</li>
 * </ul>
 *
 * <p>
 * The {@link ProjectSubLevelDTO} is primarily used for representing a simplified version of the project sub-level
 * that can be easily transferred between layers of the application, such as from the service to the controller layer.
 * </p>
 *
 * @see lombok.Data
 */
@Data
public class ProjectSubLevelDTO {
    /**
     * The unique identifier of the sub-level project.
     * <p>
     * This ID is used to uniquely identify the sub-level project within the database or system.
     * </p>
     */
    private Long id;

    /**
     * The ID or code representing the sub-level project.
     * <p>
     * This field may represent a code or identifier that ties the sub-level project to a larger project or hierarchy.
     * </p>
     */
    private Long subLevelProject;

    /**
     * The name or description of the sub-level project.
     * <p>
     * This field provides a user-friendly name or description for the sub-level project, often used for display purposes.
     * </p>
     */
    private String name;
}
