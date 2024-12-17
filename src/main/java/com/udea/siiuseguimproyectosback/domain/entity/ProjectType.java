package com.udea.siiuseguimproyectosback.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a project type entity in the system.
 * <p>
 * This class is mapped to the database table {@code SIIU_TIPO_PROYECTO}
 * and contains the properties that represent the type of a project.
 * </p>
 *
 * <p>
 * Annotations like {@link Entity} and {@link Table} are used for JPA
 * to map this class to the database table. Lombok is used to minimize
 * boilerplate code such as getters, setters, and constructors.
 * </p>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_TIPO_PROYECTO")
public class ProjectType {

    /**
     * The unique identifier for the project type.
     * <p>
     * This field is the primary key in the database table and is
     * auto-generated using the identity strategy.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    /**
     * The name of the project type.
     * <p>
     * This field represents the name of the project type and is stored
     * in the {@code NOMBRE} column of the database table.
     * </p>
     */
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String name;

}
