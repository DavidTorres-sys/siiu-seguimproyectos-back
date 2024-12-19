package com.udea.siiuseguimproyectosback.domain.entity.administrative;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Represents an administrative level entity in the system.
 * <p>
 * This class is mapped to the database table {@code SIIU_NIVEL_ADMINISTRATIVO}
 * and contains the properties and behavior of an administrative level.
 * </p>
 *
 * <p>
 * Annotations such as {@link Entity} and {@link Table} are used for JPA
 * to map this class to the database table. Lombok annotations minimize
 * boilerplate code by automatically generating getters, setters, and constructors.
 * </p>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_NIVEL_ADMINISTRATIVO")
public class AdministrativeLevel {

    /**
     * The unique identifier for the administrative level.
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
     * The name of the administrative level.
     * <p>
     * This field is stored in the {@code NOMBRE} column and
     * represents the full name of the administrative level.
     * </p>
     */
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    /**
     * Indicates if the administrative level finances calls.
     * <p>
     * This field is stored in the {@code FINANCIA_CONVOCATORIA} column.
     * A value of {@code 1} indicates that the level finances calls.
     * </p>
     */
    @Column(name = "FINANCIA_CONVOCATORIA", nullable = false)
    private Integer callFunding;

    /**
     * The code of the administrative level.
     * <p>
     * This field is stored in the {@code CODIGO} column and
     * represents the unique code for the administrative level.
     * </p>
     */
    @Column(name = "CODIGO", length = 20)
    private String code;

    /**
     * The username of the user who created this record.
     * <p>
     * This field is stored in the {@code USUARIO_CREACION} column.
     * </p>
     */
    @Column(name = "USUARIO_CREACION", length = 20)
    private String userCreation;

    /**
     * The timestamp when the record was created.
     * <p>
     * This field is stored in the {@code FECHA_CREACION} column.
     * </p>
     */
    @Column(name = "FECHA_CREACION")
    private Date creationDate;

    /**
     * The username of the user who last updated this record.
     * <p>
     * This field is stored in the {@code USUARIO_ACTUALIZA} column.
     * </p>
     */
    @Column(name = "USUARIO_ACTUALIZA", length = 20)
    private String userUpdate;

    /**
     * The timestamp when the record was last updated.
     * <p>
     * This field is stored in the {@code FECHA_ACTUALIZA} column.
     * </p>
     */
    @Column(name = "FECHA_ACTUALIZA")
    private Date updateDate;

    /**
     * Indicates if the administrative level is an administrator of other levels.
     * <p>
     * This field is stored in the {@code ES_ADMINISTRADOR_DE_OTRAS} column.
     * A value of {@code 1} indicates that it is an administrator.
     * </p>
     */
    @Column(name = "ES_ADMINISTRADOR_DE_OTRAS")
    private Integer isAdministratorOfOthers;
}
