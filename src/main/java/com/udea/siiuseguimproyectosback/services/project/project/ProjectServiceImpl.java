package com.udea.siiuseguimproyectosback.services.project.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import com.udea.siiuseguimproyectosback.domain.entity.project.SelectionProcess;
import com.udea.siiuseguimproyectosback.domain.mapper.project.IProjectMapper;
import com.udea.siiuseguimproyectosback.persistence.announcement.IAnnouncementRepository;
import com.udea.siiuseguimproyectosback.persistence.project.IProjectRepository;
import com.udea.siiuseguimproyectosback.persistence.project.ISelectionProcessRepository;
import com.udea.siiuseguimproyectosback.services.project.project.filter.IProjectFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService{

    private final IProjectRepository projectRepository;
    private final IAnnouncementRepository announcementRepository;
    private final IProjectMapper projectMapper;
    private final ISelectionProcessRepository selectionProcessRepository;
    private final IProjectFilterService projectFilterService;

    @Autowired
    public ProjectServiceImpl(IProjectRepository projectRepository,
                              IAnnouncementRepository announcementRepository,
                              IProjectMapper projectMapper,
                              ISelectionProcessRepository selectionProcessRepository,
                              IProjectFilterService projectFilterService) {
        this.projectRepository = projectRepository;
        this.announcementRepository = announcementRepository;
        this.projectMapper = projectMapper;
        this.selectionProcessRepository = selectionProcessRepository;
        this.projectFilterService = projectFilterService;
    }

    @Override
    public Optional<List<ProjectDTO>> filter(ProjectFilterPayloadDTO filterDTO) {
        try {
            List<Project> projects = projectRepository
                    .findByAdministrativeCenter(filterDTO.getAdministrativeCenterId())
                    .orElse(Collections.emptyList());

            Predicate<Project> projectPredicate = projectFilterService.createProjectPredicate(filterDTO);

            List<ProjectDTO> projectDTOs = projects
                    .stream()
                    .filter(projectPredicate)
                    .map(projectMapper::toDTO)
                    .collect(Collectors.toList());

            return projectDTOs.isEmpty() ? Optional.empty() : Optional.of(projectDTOs);

        } catch (DataAccessException e) {
            throw new RuntimeException("Database error while filtering projects.", e);
        } catch (Exception e) {
            throw new RuntimeException("Error desconocido al intentar filtrar proyectos.", e);
        }
    }
}
