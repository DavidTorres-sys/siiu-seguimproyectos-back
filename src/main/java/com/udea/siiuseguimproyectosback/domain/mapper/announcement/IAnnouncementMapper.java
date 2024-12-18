package com.udea.siiuseguimproyectosback.domain.mapper.announcement;

import com.udea.siiuseguimproyectosback.domain.dto.announcement.AnnouncementDTO;
import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between {@link Announcement} entities and {@link AnnouncementDTO} objects.
 *
 * <p>This interface extends the generic {@link IEntityMapper} interface and defines mapping behavior
 * specific to the {@link Announcement} entity and its corresponding {@link AnnouncementDTO}.
 * The mapping process is automatically implemented by MapStruct.</p>
 *
 * <p>The {@code componentModel = "spring"} parameter enables Spring dependency injection
 * for the generated implementation, making it a Spring-managed bean.</p>
 *
 * Example Usage:
 * <pre>
 *     {@code
 *     @Autowired
 *     private IAnnouncementMapper announcementMapper;
 *
 *     AnnouncementDTO dto = announcementMapper.toDto(announcement);
 *     Announcement entity = announcementMapper.toEntity(dto);
 *     }
 * </pre>
 *
 * @see Announcement
 * @see AnnouncementDTO
 * @see IEntityMapper
 */
@Mapper(componentModel = "spring")
public interface IAnnouncementMapper extends IEntityMapper<AnnouncementDTO, Announcement> { }
