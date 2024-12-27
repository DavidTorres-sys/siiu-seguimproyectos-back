package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.Project;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends JpaRepository<Project, String>, JpaSpecificationExecutor<Project> {
    Optional<List<Project>> findByAdministrativeCenter(Long administrativeCenterId, Pageable pageable);

}
