package com.udea.siiuseguimproyectosback.controllers.v1.announcement;

import com.udea.siiuseguimproyectosback.domain.dto.announcement.AnnouncementDTO;
import com.udea.siiuseguimproyectosback.services.announcement.announcement.IAnnouncementService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/convocatoria")
@Tag(name = "Announcement Management", description = "Operations for managing Announcement")
public class AnnouncementController {

    private final IAnnouncementService announcementService;

    @Autowired
    public AnnouncementController(IAnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/lista-convocatorias")
    public ResponseEntity<List<AnnouncementDTO>> getAll(
            @Parameter(description = "Number of records to skip (pagination offset)", example = "0")
            @RequestParam(defaultValue = "0") Integer skip,

            @Parameter(description = "Maximum number of records to return (pagination limit)", example = "10")
            @RequestParam(defaultValue = "10") Integer limit) {

        return announcementService.getAll(skip, limit).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
