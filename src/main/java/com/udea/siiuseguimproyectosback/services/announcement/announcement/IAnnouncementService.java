package com.udea.siiuseguimproyectosback.services.announcement.announcement;

import com.udea.siiuseguimproyectosback.domain.dto.announcement.AnnouncementDTO;

import java.util.List;
import java.util.Optional;

public interface IAnnouncementService {

    Optional<List<AnnouncementDTO>> getAll(Integer skip, Integer limit);
}
