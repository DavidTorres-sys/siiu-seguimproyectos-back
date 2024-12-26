package com.udea.siiuseguimproyectosback.services.project.project.filter;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ProjectFilterServiceImpl implements IProjectFilterService {
    public Predicate<Project> createProjectPredicate(ProjectFilterPayloadDTO filterDTO) {
        return project ->
                isMatching(filterDTO.getProjectCode(), project.getCode()) &&
                        isMatching(filterDTO.getStatus(), project.getStatus()) &&
                        isMatching(filterDTO.getAnnouncementId(), project.getAnnouncement()) &&
                        isMatching(filterDTO.getSelectionProcessId(), project.getSelectionProcess());
    }

    private boolean isMatching(Object filterValue, Object projectValue) {
        return Optional.ofNullable(filterValue)
                .map(value -> value.equals(projectValue))
                .orElse(true);
    }
}
