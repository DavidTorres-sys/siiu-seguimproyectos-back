package com.udea.siiuseguimproyectosback.services.project.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectMapper;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectRepository;
import com.udea.siiuseguimproyectosback.utils.ValidateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
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
    public Optional<List<ProjectDTO>> filter(
            UserSessionDTO user,
            ProjectFilterPayloadDTO filterDTO,
            Integer skip,
            Integer limit) {

        ValidateParams.validatePaginationParams(skip, limit);
        try {
            List<ProjectDTO> projects = projectRepository
                    .findByFilters(user.getDocumentNumber(),
                        filterDTO.getAdministrativeCenterId(),
                        filterDTO.getProjectCode(),
                        filterDTO.getStatus(),
                        filterDTO.getAnnouncementId(),
                        filterDTO.getSelectionProcessId(),
                        filterDTO.getProjectTypeId(),
                        PageRequest.of(skip / limit, limit))
                    .stream()
                    .map(projectMapper::toDTO)
                    .collect(Collectors.toList());

            return Optional.ofNullable(projects.isEmpty() ? null : projects);
        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while filtering projects.", e);
        } catch (Exception e) {
            throw new RuntimeException("Unknown error occurred while filtering projects.", e);
        }
    }
}
