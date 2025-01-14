package com.udea.siiuseguimproyectosback.domain.dto.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.Project;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing a {@link Project}.
 * <p>
 * This class serves as a data carrier between layers (such as the service and controller layers) of the application.
 * It contains the essential information about a project that needs to be transferred over the network or processed.
 * </p>
 *
 * <h3>Key Attributes:</h3>
 * <ul>
 *   <li><b>code:</b> The unique code of the project.</li>
 *   <li><b>shortName:</b> A short, user-friendly name or identifier for the project.</li>
 *   <li><b>status:</b> The current status of the project.</li>
 *   <li><b>projectSubLevel:</b> The sub-level classification of the project.</li>
 *   <li><b>announcement:</b> The short name of the announcement associated with the project.</li>
 *   <li><b>selectionProcess:</b> The name of the selection process related to the project.</li>
 *   <li><b>responsible:</b> The person or entity responsible for managing the project.</li>
 *   <li><b>projectSubtype:</b> The subtype classification of the project.</li>
 * </ul>
 *
 * <p>
 * The {@link ProjectDTO} is used primarily to represent the project data in a simplified form suitable for
 * communication between different application layers, without exposing the underlying entity structure.
 * </p>
 *
 * @see Project
 * @see lombok.Data
 */
@Data
public class ProjectDTO {
    /**
     * The unique code of the project.
     * <p>
     * This code is used to identify the project in various contexts, such as in queries or reporting.
     * </p>
     */
    private String code;

    /**
     * A short, user-friendly name or identifier for the project.
     * <p>
     * This name is typically used for display purposes in user interfaces or reports.
     * </p>
     */
    private String shortName;

    /**
     * The current status of the project (e.g., "active", "completed").
     * <p>
     * This field reflects the project's lifecycle stage or completion state.
     * </p>
     */
    private String status;

    /**
     * The sub-level classification of the project (e.g., "Level 1").
     * <p>
     * This field categorizes the project within a hierarchical structure or a set of sub-levels.
     * </p>
     */
    private String projectSubLevel;

    /**
     * The short name of the announcement associated with the project.
     * <p>
     * This field refers to the announcement related to the project, which could represent a funding
     * or procurement notice, for example.
     * </p>
     */
    private String announcement;

    /**
     * The name of the selection process related to the project.
     * <p>
     * This field identifies the selection process (such as a recruitment or procurement process)
     * that the project is part of.
     * </p>
     */
    private String selectionProcess;

    /**
     * The person or entity responsible for managing the project.
     * <p>
     * This field identifies the individual or organization accountable for the project's execution.
     * </p>
     */
    private String responsible;

    /**
     * The subtype classification of the project (e.g., "Research", "Development").
     * <p>
     * This field categorizes the project by its specific type or focus area.
     * </p>
     */
    private String projectSubtype;

    private String ipCoordinator;
}
