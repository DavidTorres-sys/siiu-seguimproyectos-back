package com.udea.siiuseguimproyectosback.domain.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class representing a Selection Process in the system.
 * <p>
 * This class maps to the database table {@code SIIU_PROCESO_SELECCION} and contains
 * attributes related to the configuration and metadata of a selection process.
 * </p>
 * <p>
 * The {@code SelectionProcess} entity is used to persist and retrieve data
 * from the database, with fields annotated for proper mapping.
 * </p>
 * <p>
 * This class is annotated with Lombok's {@link Data} and {@link NoArgsConstructor}
 * to reduce boilerplate code for getters, setters, and constructors.
 * </p>
 *
 * @see lombok.Data
 * @see lombok.NoArgsConstructor
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PROCESO_SELECCION")
public class SelectionProcess {

    /**
     * Primary key, unique identifier for the selection process.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    /**
     * The type of project associated with this selection process.
     */
    @Column(name = "TIPO_PROYECTO", nullable = false, length = 3)
    private Integer projectType;

    /**
     * Identifier for the evaluator list manager.
     */
    @Column(name = "RESPONSABLE_LISTA_EVALUADORES", nullable = false, length = 2)
    private Integer responsibleEvaluatorList;

    /**
     * Indicator whether there are description limits.
     */
    @Column(name = "LIMITA_DESCRIPCIONES", nullable = false, length = 2)
    private Integer limitDescriptions;

    /**
     * Start date of the selection process validity period.
     */
    @Column(name = "INICIO_VIGENCIA")
    private Date startValidity;

    /**
     * End date of the selection process validity period.
     */
    @Column(name = "FIN_VIGENCIA")
    private Date endValidity;

    /**
     * Name of the selection process.
     */
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    /**
     * Description of the selection process.
     */
    @Column(name = "DESCRIPCION", length = 400)
    private String description;

    // Required fields for the process
    @Column(name = "REQUERIDO_DESCRIPCION", nullable = false, length = 38)
    private Long requiredDescription;

    @Column(name = "REQUERIDO_PARTICIPANTE", nullable = false, length = 38)
    private Long requiredParticipant;

    @Column(name = "REQUERIDO_CRONOGRAMA", nullable = false, length = 38)
    private Long requiredSchedule;

    @Column(name = "REQUERIDO_PRESUPUESTO", nullable = false, length = 38)
    private Long requiredBudget;

    @Column(name = "REQUERIDO_EVALUADOR", nullable = false, length = 38)
    private Long requiredEvaluator;

    @Column(name = "REQUERIDO_COMPROMISO", nullable = false, length = 38)
    private Long requiredCommitment;

    @Column(name = "REQUERIDO_PLAN_TRABAJO", nullable = false, length = 38)
    private Long requiredWorkPlan;

    @Column(name = "REQUERIDO_ENCUESTA", length = 38)
    private Long requiredSurvey;

    // Additional metadata
    @Column(name = "NIVEL_PROYECTO", length = 5)
    private Integer projectLevel;

    @Column(name = "SUBTIPO_PROYCETO", length = 3)
    private Integer projectSubtype;

    @Column(name = "SUBNIVEL_PROYECTO", length = 3)
    private Integer projectSublevel;

    @Column(name = "CLASIFICACION", length = 20)
    private String classification;

    @Column(name = "CLASE_SUBPROYECTO", length = 20)
    private Integer subprojectClass;

    /**
     * Current state of the selection process.
     */
    @Column(name = "ESTADO", nullable = false, length = 31)
    private String state;

    @Column(name = "REQUERIDO_INFO_COMPLEMENTARIA", length = 38)
    private Long requiredAdditionalInfo;
}
