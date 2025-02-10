package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for filtering projects based on multiple criteria.
 * <p>
 * This class encapsulates the filter parameters used to query or search for projects.
 * It is designed to be used in the API layer to receive and pass filtering data
 * between the client and the backend services.
 */
@Data
public class ProjectFilterPayloadDTO {

    /**
     * The unique code identifying the project.
     * <p>
     * This field is used to filter projects by their specific codes.
     */
    private String projectCode;

    /**
     * The identifier of the administrative center associated with the project.
     * <p>
     * Used to filter projects that belong to a specific administrative center.
     */
    private Long administrativeCenterId;

    /**
     * The current state or status of the project.
     * <p>
     * This field allows filtering projects based on their lifecycle or status.
     */
    private String status;

    /**
     * The identifier of the announcement associated with the project.
     * <p>
     * This field is used to filter projects related to a specific announcement or call.
     */
    private Long announcementId;

    /**
     * The identifier of the process selection associated with the project.
     * <p>
     * This field allows filtering projects based on the selection process they are part of.
     */
    private Long selectionProcessId;

    /**
     * The identifier of the project type.
     * <p>
     * This field is used to filter projects by their type.
     */
    private Long projectTypeId;
}
