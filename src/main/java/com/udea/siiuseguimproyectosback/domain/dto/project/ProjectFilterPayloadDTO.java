package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

@Data
public class ProjectFilterPayloadDTO {
    private String projectCode;
    private Long administrativeCenterId;
    private String state;
    private Long announcementId;
    private Long processSelectionId;
    private Long projectTypeId;
}
