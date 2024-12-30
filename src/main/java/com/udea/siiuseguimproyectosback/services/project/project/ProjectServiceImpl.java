package com.udea.siiuseguimproyectosback.services.project.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectRepository;
import com.udea.siiuseguimproyectosback.utils.ValidateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectRepository projectRepository;
    private final IProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(IProjectRepository projectRepository,
                              IProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Optional<List<ProjectDTO>> filter(ProjectFilterPayloadDTO filterDTO, Integer skip, Integer limit) {
        ValidateParams.validatePaginationParams(skip, limit);
        try {

            Pageable pageable = PageRequest.of(skip / limit, limit);

            List<Project> projects = projectRepository.findByFilters(
                    filterDTO.getAdministrativeCenterId(),
                    filterDTO.getProjectCode(),
                    filterDTO.getStatus(),
                    filterDTO.getAnnouncementId(),
                    filterDTO.getSelectionProcessId(),
                    pageable
            );

            List<ProjectDTO> projectDTOs = projects
                    .stream()
                    .map(projectMapper::toDTO)
                    .collect(Collectors.toList());

            return Optional.ofNullable(projectDTOs.isEmpty() ? null : projectDTOs);
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while filtering projects.", e);
        } catch (Exception e) {
            throw new RuntimeException("Unknown error occurred while filtering projects.", e);
        }
    }
}
