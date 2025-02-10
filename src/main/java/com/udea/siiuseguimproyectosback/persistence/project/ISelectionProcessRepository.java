package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.SelectionProcess;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link SelectionProcess} entities.
 * <p>
 * This interface provides CRUD operations and query support for {@link SelectionProcess} entities.
 * It extends the {@link JpaRepository}, inheriting standard methods for data access and manipulation.
 * </p>
 *
 * <ul>
 *   <li><b>Save:</b> Persists a new or updated {@link SelectionProcess} entity to the database.</li>
 *   <li><b>Find:</b> Retrieves {@link SelectionProcess} entities by their primary key or other criteria.</li>
 *   <li><b>Delete:</b> Removes a {@link SelectionProcess} entity from the database.</li>
 *   <li><b>Pagination and Sorting:</b> Supports paginated and sorted queries.</li>
 * </ul>
 *
 * <p>
 * The repository interface follows the Spring Data JPA pattern, which automatically generates
 * implementations for the defined methods at runtime.
 * </p>
 *
 * @see SelectionProcess
 * @see JpaRepository
 */
public interface ISelectionProcessRepository extends JpaRepository<SelectionProcess, Long> { }
