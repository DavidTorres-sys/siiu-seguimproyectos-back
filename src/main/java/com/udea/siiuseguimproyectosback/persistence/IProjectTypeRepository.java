package com.udea.siiuseguimproyectosback.persistence;

import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link ProjectType} entities.
 * <p>
 * This interface extends {@link JpaRepository}, providing built-in CRUD operations
 * and additional methods for database interactions.
 * </p>
 *
 * <p>
 * The Spring Data JPA framework will automatically generate the implementation
 * of this repository interface at runtime.
 * </p>
 */
public interface IProjectTypeRepository extends JpaRepository<ProjectType, Long> { }
