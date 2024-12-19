package com.udea.siiuseguimproyectosback.domain.entity.administrative;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents an administrative center entity in the system.
 *
 * <p>
 * This class maps to the database table {@code SIIU_INSTANCIA_ADMINISTRATIVA}
 * and defines the properties and behaviors of an administrative center. It is
 * a core component for managing organizational and project-related information
 * within the system.
 * </p>
 *
 * <p>
 * Annotations such as {@link Entity} and {@link Table} facilitate the mapping
 * of this class to the database table. {@link Data} and {@link NoArgsConstructor}
 * from Lombok are used to reduce boilerplate code, automatically generating
 * getters, setters, equals, hashCode, toString, and a no-arguments constructor.
 * </p>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_INSTANCIA_ADMINISTRATIVA")
public class AdministrativeCenter {

    /**
     * The unique identifier for the administrative center.
     * <p>
     * This field serves as the primary key in the database and is
     * auto-generated using the {@code IDENTITY} strategy.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    /**
     * Indicates whether the administrative center manages projects.
     */
    @Column(name = "ADMINISTRA_PROYECTO", nullable = false)
    private Long managesProjects;

    /**
     * The administrative level of the center, represented as a foreign key.
     * <p>
     * This column stores the identifier of the corresponding administrative
     * level but is not mapped as a relationship for simplicity.
     * </p>
     */
    @Column(name = "NIVEL_ADMINISTRATIVO", nullable = false)
    private Long administrativeLevel;

    /**
     * The identifier of the superior administrative instance.
     */
    @Column(name = "INSTANCIA_SUPERIOR", nullable = false)
    private Long superiorInstance;

    /**
     * The full name of the administrative center.
     */
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    /**
     * The short name or abbreviation of the administrative center.
     */
    @Column(name = "NOMBRE_CORTO", nullable = false, length = 60)
    private String shortName;

    /**
     * The name of the center's boss or leader.
     */
    @Column(name = "JEFE", length = 150)
    private String boss;

    /**
     * Indicates whether the administrative center is enabled.
     */
    @Column(name = "HABILITADA", nullable = false, length = 2)
    private Integer enabled;

    /**
     * The email address of the administrative center.
     */
    @Column(name = "CORREO", length = 100)
    private String email;

    /**
     * The contact phone number of the administrative center.
     */
    @Column(name = "TELEFONO", length = 15)
    private String phone;

    /**
     * The fax number of the administrative center.
     */
    @Column(name = "FAX", length = 15)
    private String fax;

    /**
     * The website URL of the administrative center.
     */
    @Column(name = "PAGINA_WEB", length = 200)
    private String website;

    /**
     * The physical location of the administrative center.
     */
    @Column(name = "UBICACION_FISICA", length = 100)
    private String physicalLocation;

    /**
     * The username of the user who created this record.
     */
    @Column(name = "USUARIO_CREACION", length = 20)
    private String creationUser;

    /**
     * The date and time when this record was created.
     */
    @Column(name = "FECHA_CREACION")
    private Date creationDate;

    /**
     * The username of the user who last updated this record.
     */
    @Column(name = "USUARIO_ACTUALIZA", length = 20)
    private String updateUser;

    /**
     * The date and time when this record was last updated.
     */
    @Column(name = "FECHA_ACTUALIZA")
    private Date updateDate;

    /**
     * The unique code identifying the administrative center.
     */
    @Column(name = "CODIGO", length = 20)
    private String code;

    /**
     * The identifier of the boss or leader of the administrative center.
     */
    @Column(name = "IDENTIFICACION_JEFE", length = 20)
    private String bossId;

    /**
     * The position or role of the boss in the administrative center.
     */
    @Column(name = "CARGO_JEFE", length = 50)
    private String bossPosition;

    /**
     * Indicates whether this is an administrative instance (1 = true, 0 = false).
     */
    @Column(name = "INSTANCIA_ADMINISTRADORA", length = 5)
    private Integer administrativeInstance;

    /**
     * Indicates whether the center has special privileges.
     */
    @Column(name = "ES_ESPECIAL", length = 5)
    private String isSpecial;

    /**
     * Indicates whether instance-level returns are allowed.
     */
    @Column(name = "DEVOLUCION_ENTRE_INSTANCIAS", length = 1)
    private Integer returnBetweenInstances;

    /**
     * The dependency identifier in the Planview system.
     */
    @Column(name = "DEPENDENCIA_PLANVIEW", length = 20)
    private String planviewDependency;

    /**
     * The identifier for the center in the Planview system.
     */
    @Column(name = "IDENTIFICADOR_PLANVIEW", length = 50)
    private Integer planviewId;
}
