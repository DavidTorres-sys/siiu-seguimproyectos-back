package com.udea.siiuseguimproyectosback.services.project.project;

import com.udea.siiuseguimproyectosback.core.security.user.UserSession;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<List<ProjectDTO>> filter(ProjectFilterPayloadDTO filterDTO, Integer skip, Integer limit);

}
