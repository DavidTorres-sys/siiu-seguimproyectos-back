package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

@Data
public class ProjectDTO {
    private String code;
    private String shortName;
    private String status;
    private String subLevelProject;
    private String announcement;
    private String selectionProcess;
    private String responsible;
    private String projectType;
}
