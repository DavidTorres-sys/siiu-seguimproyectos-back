package com.udea.siiuseguimproyectosback.domain.dto.project;

import lombok.Data;

import java.util.List;

@Data
public class ProjectParticipantDTO {
    private String id;
    private String project;
    private String responsible;
    private List<ProjectParticipantRolDTO> projectParticipantRole;
}
