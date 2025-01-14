package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {
}
