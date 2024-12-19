package com.udea.siiuseguimproyectosback.services.announcement.announcement;

import com.udea.siiuseguimproyectosback.core.exception.DataNotFoundException;
import com.udea.siiuseguimproyectosback.domain.dto.announcement.AnnouncementDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.mapper.announcement.IAnnouncementMapper;
import com.udea.siiuseguimproyectosback.persistence.announcement.IAnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    private final IAnnouncementRepository announcementRepository;
    private final IAnnouncementMapper announcementMapper;

    @Autowired
    public AnnouncementServiceImpl(IAnnouncementRepository announcementRepository,
                                   IAnnouncementMapper announcementMapper) {
        this.announcementRepository = announcementRepository;
        this.announcementMapper = announcementMapper;
    }

    @Override
    public Optional<List<AnnouncementDTO>> getAll(Integer skip, Integer limit) {
        if (skip < 0 || limit <= 0) {
            throw new IllegalArgumentException("Los valores de 'skip' y 'limit' deben ser mayores a cero.");
        }
        try {
            List<Announcement> announcements = announcementRepository
                    .findAll(PageRequest.of(skip, limit))
                    .getContent();

            if(announcements.isEmpty()) {
                throw new DataNotFoundException("No se encontraron convocatorias.");
            }
            return Optional.of(announcementMapper.toDTO(announcements));
        } catch (DataNotFoundException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Parámetros inválidos: skip=" + skip + " limit=" + limit);
        } catch (Exception e) {
            throw new RuntimeException("Error desconocido al intentar obtener las convocatorias.", e);
        }
    }
}
