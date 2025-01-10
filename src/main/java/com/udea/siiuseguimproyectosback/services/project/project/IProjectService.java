package com.udea.siiuseguimproyectosback.services.project.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<List<ProjectDTO>> filter(
            UserSessionDTO user,
            ProjectFilterPayloadDTO filterDTO,
            Integer skip,
            Integer limit);

}
