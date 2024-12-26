package com.udea.siiuseguimproyectosback.services.project.project.filter;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;

import java.util.function.Predicate;

public interface IProjectFilterService {
    Predicate<Project> createProjectPredicate(ProjectFilterPayloadDTO filterDTO);
}
