package com.udea.siiuseguimproyectosback.persistence.announcement;

import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Announcement} entities.
 * <p>
 * This interface extends the {@link JpaRepository} interface from Spring Data JPA, which provides methods
 * for performing CRUD operations on {@link Announcement} entities. It allows interaction with the
 * database to save, retrieve, update, and delete announcement data.
 * </p>
 *
 * <p>
 * The {@link IAnnouncementRepository} is automatically implemented by Spring Data JPA at runtime.
 * Additional query methods can be added as needed.
 * </p>
 *
 * @see JpaRepository
 * @see Announcement
 */
public interface IAnnouncementRepository extends JpaRepository<Announcement, Long> { }
