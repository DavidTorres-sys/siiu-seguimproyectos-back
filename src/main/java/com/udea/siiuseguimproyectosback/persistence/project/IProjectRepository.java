package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


/**
 * Repository interface for managing {@link Project} entities.
 * <p>
 * This interface provides CRUD operations and custom query support for {@link Project} entities.
 * It extends the {@link JpaRepository}, inheriting standard methods for data access and manipulation.
 * </p>
 *
 * <ul>
 *   <li><b>Save:</b> Persists a new or updated {@link Project} entity to the database.</li>
 *   <li><b>Find:</b> Retrieves {@link Project} entities by their primary key or other criteria.</li>
 *   <li><b>Delete:</b> Removes a {@link Project} entity from the database.</li>
 *   <li><b>Pagination and Sorting:</b> Supports paginated and sorted queries.</li>
 *   <li><b>Custom Query:</b> Provides a method for dynamic filtering of {@link Project} entities using multiple optional parameters.</li>
 * </ul>
 *
 * <p>
 * The repository interface follows the Spring Data JPA pattern, which automatically generates
 * implementations for the defined methods at runtime.
 * </p>
 *
 * @see Project
 * @see JpaRepository
 */
public interface IProjectRepository extends JpaRepository<Project, String> {


    /**
     * Finds projects based on required and optional filter criteria. The query dynamically applies
     * optional filters depending on the non-null parameters provided.
     * <p>
     * This method uses a JPQL query with named parameters to perform a dynamic search. It requires
     * the `administrativeCenterId` parameter and supports additional optional filters, including
     * project code, status, announcement ID, and selection process ID. Pagination and sorting
     * are handled via the {@link Pageable} parameter.
     * </p>
     *
     * <h3>Filter Details:</h3>
     * <ul>
     *   <li><b>Administrative Center:</b> Filters projects by their administrative center ID (required).</li>
     *   <li><b>Project Code:</b> Filters projects by their unique code (optional).</li>
     *   <li><b>Status:</b> Filters projects by their current status (optional).</li>
     *   <li><b>Announcement ID:</b> Filters projects associated with a specific announcement (optional).</li>
     *   <li><b>Selection Process ID:</b> Filters projects associated with a specific selection process (optional).</li>
     * </ul>
     *
     * <p>
     * The `administrativeCenterId` parameter must not be {@code null}. All other parameters can be
     * set to {@code null} to exclude the corresponding filter from the query.
     * </p>
     *
     * @param administrativeCenterId the ID of the administrative center. This parameter is required.
     * @param projectCode the unique code of the project. If {@code null}, this filter is ignored.
     * @param status the current status of the project. If {@code null}, this filter is ignored.
     * @param announcementId the ID of the announcement associated with the project. If {@code null}, this filter is ignored.
     * @param selectionProcessId the ID of the selection process associated with the project. If {@code null}, this filter is ignored.
     * @param pageable a {@link Pageable} object to support pagination and sorting.
     * @return a list of {@link Project} entities that match the given filters.
     * @see Pageable
     */
    @Query("SELECT p FROM Project p " +
            "WHERE p.administrativeCenter = :administrativeCenterId " +
            "AND (:projectCode IS NULL OR p.code = :projectCode) " +
            "AND (:status IS NULL OR p.status = :status) " +
            "AND (:announcementId IS NULL OR p.announcement.id = :announcementId) " +
            "AND (:selectionProcessId IS NULL OR p.selectionProcess.id = :selectionProcessId) " +
            "AND (:projectTypeId IS NULL OR p.projectSubtype.projectType.id = :projectTypeId)" +
            "AND p.responsible.id = :responsible")
    Page<Project> findByFilters(
            @Param("responsible") String responsible,
            @Param("administrativeCenterId") Long administrativeCenterId,
            @Param("projectCode") String projectCode,
            @Param("status") String status,
            @Param("announcementId") Long announcementId,
            @Param("selectionProcessId") Long selectionProcessId,
            @Param("projectTypeId") Long projectTypeId,
            Pageable pageable);

    @Query("SELECT DISTINCT p.status FROM Project p " +
            "WHERE p.responsible.id = :responsible")
    List<String> findAllDistinctStatus(@Param("responsible") String responsible);
}
