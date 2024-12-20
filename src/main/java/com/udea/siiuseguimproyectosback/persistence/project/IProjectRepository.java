package com.udea.siiuseguimproyectosback.persistence.project;

import com.udea.siiuseguimproyectosback.domain.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, String> { }
