package com.udea.siiuseguimproyectosback.persistence.administrative;

import com.udea.siiuseguimproyectosback.domain.entity.administrative.AdministrativeCenter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link AdministrativeCenter} entities.
 * <p>
 * This interface extends {@link JpaRepository} and provides CRUD operations for the {@link AdministrativeCenter} entity.
 * By extending JpaRepository, it inherits several methods for basic persistence operations such as saving, deleting, and finding entities.
 * </p>
 * <p>
 * The {@link JpaRepository} is part of the Spring Data JPA framework, which automatically provides the implementation of
 * these methods at runtime. This allows for easy interaction with the database without the need for custom implementation.
 * </p>
 *
 * @see AdministrativeCenter
 * @see JpaRepository
 */
public interface IAdministrativeCenterRepository extends JpaRepository<AdministrativeCenter, Long> { }
