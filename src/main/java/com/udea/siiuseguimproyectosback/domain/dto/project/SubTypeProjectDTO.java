package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

@Data
public class SubTypeProjectDTO {
    private Long id;
    private String name;
    private ProjectTypeDTO typeProject;
}
