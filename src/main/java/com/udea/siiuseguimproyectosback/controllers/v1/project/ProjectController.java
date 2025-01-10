package com.udea.siiuseguimproyectosback.controllers.v1.project;

import com.udea.siiuseguimproyectosback.core.security.user.Session;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectDTO;
import com.udea.siiuseguimproyectosback.domain.dto.project.ProjectFilterPayloadDTO;
import com.udea.siiuseguimproyectosback.domain.dto.user.UserSessionDTO;
import com.udea.siiuseguimproyectosback.services.project.project.IProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1/proyecto")
@Tag(name = "Project Management", description = "Operations for managing project")
public class ProjectController {

    private final IProjectService projectService;
    private final Session session;
    private final HttpServletRequest request;

    @Autowired
    public ProjectController(IProjectService projectService,
                             Session session,
                             HttpServletRequest request) {
        this.projectService = projectService;
        this.session = session;
        this.request = request;
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
            @RequestParam(required = false) Long projectTypeId) {

        ProjectFilterPayloadDTO payload = new ProjectFilterPayloadDTO();
        payload.setAdministrativeCenterId(administrativeCenterId);
        payload.setProjectCode(projectCode);
        payload.setStatus(status);
        payload.setAnnouncementId(announcementId);
        payload.setSelectionProcessId(processSelectionId);
        payload.setProjectTypeId(projectTypeId);

        //UserSessionDTO user = session.getCurrentUser(request);
        // Hardcoded user for testing
        UserSessionDTO user = new UserSessionDTO();
        user.setDocumentNumber("70553732");

        return projectService
                .filter(user, payload, skip, limit)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
