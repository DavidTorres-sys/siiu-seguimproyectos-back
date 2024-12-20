package com.udea.siiuseguimproyectosback.domain.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @Column(name = "TIPO_PROYECTO", nullable = false)
    private Integer projectType;

    /**
     * Identifier for the evaluator list manager.
     */
    @NotNull
    @Column(name = "RESPONSABLE_LISTA_EVALUADORES", nullable = false)
    private Integer responsibleEvaluatorList;

    /**
     * Indicator whether there are description limits.
     */
    @NotNull
    @Column(name = "LIMITA_DESCRIPCIONES", nullable = false)
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
    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    /**
     * Description of the selection process.
     */
    @Size(max = 400)
    @Column(name = "DESCRIPCION", length = 400)
    private String description;

    // Required fields for the process
    @NotNull
    @Column(name = "REQUERIDO_DESCRIPCION", nullable = false)
    private Long requiredDescription;

    @NotNull
    @Column(name = "REQUERIDO_PARTICIPANTE", nullable = false)
    private Long requiredParticipant;

    @NotNull
    @Column(name = "REQUERIDO_CRONOGRAMA", nullable = false)
    private Long requiredSchedule;

    @NotNull
    @Column(name = "REQUERIDO_PRESUPUESTO", nullable = false)
    private Long requiredBudget;

    @NotNull
    @Column(name = "REQUERIDO_EVALUADOR", nullable = false)
    private Long requiredEvaluator;

    @NotNull
    @Column(name = "REQUERIDO_COMPROMISO", nullable = false)
    private Long requiredCommitment;

    @NotNull
    @Column(name = "REQUERIDO_PLAN_TRABAJO", nullable = false)
    private Long requiredWorkPlan;

    @NotNull
    @Column(name = "REQUERIDO_ENCUESTA")
    private Long requiredSurvey;

    // Additional metadata
    @Column(name = "NIVEL_PROYECTO")
    private Integer projectLevel;

    @Column(name = "SUBTIPO_PROYCETO")
    private Integer projectSubtype;

    @Column(name = "SUBNIVEL_PROYECTO")
    private Integer projectSublevel;

    @Column(name = "CLASIFICACION")
    private String classification;

    @Column(name = "CLASE_SUBPROYECTO")
    private Integer subprojectClass;

    /**
     * Current state of the selection process.
     */
    @NotNull
    @Size(max = 31)
    @Column(name = "ESTADO", nullable = false, length = 31)
    private String state;

    @Column(name = "REQUERIDO_INFO_COMPLEMENTARIA")
    private Long requiredAdditionalInfo;
}
