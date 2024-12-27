package com.udea.siiuseguimproyectosback.controllers.v1.project;

import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.services.project.project.IProjectService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/proyecto")
@Tag(name = "Project Management", description = "Operations for managing project")
public class ProjectController {

    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<ProjectDTO>> filter(
            @RequestParam(defaultValue = "0") Integer skip,
            @RequestParam(defaultValue = "25") Integer limit,
            @RequestParam Long administrativeCenterId,
            @RequestParam(required = false) String projectCode,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long announcementId,
            @RequestParam(required = false) Long processSelectionId,
            @RequestParam(required = false) Long projectTypeId
    ) {
        ProjectFilterPayloadDTO payload = new ProjectFilterPayloadDTO();
        payload.setAdministrativeCenterId(administrativeCenterId);
        payload.setProjectCode(projectCode);
        payload.setStatus(status);
        payload.setAnnouncementId(announcementId);
        payload.setSelectionProcessId(processSelectionId);
        payload.setProjectTypeId(projectTypeId);

        return projectService
                .filter(payload, skip, limit)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
