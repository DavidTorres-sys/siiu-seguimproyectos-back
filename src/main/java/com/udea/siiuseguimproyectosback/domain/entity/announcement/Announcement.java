package com.udea.siiuseguimproyectosback.domain.entity.announcement;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Represents an Announcement entity mapped to the "SIIU_CONVOCATORIA" table in the database.
 * <p>
 * This entity stores all relevant data regarding project announcements, including identification details,
 * important dates, project constraints, and budget management configurations.
 * It is used to manage the lifecycle of calls for research or project proposals in the system.
 * </p>
 *
 * <p>Key Features:</p>
 * <ul>
 *     <li>Contains essential metadata like creation date, publication date, and closing date.</li>
 *     <li>Defines constraints for project execution timelines, such as maximum extensions or suspensions.</li>
 *     <li>Supports additional descriptive fields such as URL links, comments, and short names for clarity.</li>
 *     <li>Includes fields for managing the budgeting period and total budget periods.</li>
 * </ul>
 *
 * <p>
 * This entity is designed to be immutable for key fields like {@code id} after creation to ensure data integrity.
 * </p>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_CONVOCATORIA")
public class Announcement {

    /** Unique identifier for the announcement. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    /** Code of the financier providing the funds for the announcement. */
    @NotNull
    @Size(max = 20)
    @Column(name = "CODIGO_FINANCIADOR", length = 20)
    private String financierCode;

    /** Reference to the selection process used for the projects in the announcement. */
    @NotNull
    @Column(name = "PROCESO_SELECCION", nullable = false)
    private Integer selectionProcess;

    /** Reference to the person or entity who registered the announcement. */
    @NotNull
    @Size(max = 16)
    @Column(name = "REGISTRADOR", nullable = false, length = 16)
    private String registrar;

    /** Date when the announcement was created. */
    @NotNull
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date creationDate;

    /** Date when the announcement was published. */
    @Column(name = "FECHA_PUBLICACION")
    private Date publicationDate;

    /** Date of the last modification made to the announcement. */
    @NotNull
    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    private Date lastModifiedDate;

    /** Date when the announcement closes for project submissions. */
    @Column(name = "FECHA_CIERRE")
    private Date closingDate;

    /** Date when the announcement opens for project submissions. */
    @Column(name = "FECHA_APERTURA")
    private Date openingDate;

    /** Date when the results of the announcement are published. */
    @Column(name = "FECHA_RESULTADOS")
    private Date resultsDate;

    /** Full name of the announcement. */
    @NotNull
    @Size(max = 400)
    @Column(name = "NOMBRE", length = 400, nullable = false)
    private String name;

    /** Short name of the announcement. */
    @NotNull
    @Size(max = 100)
    @Column(name = "NOMBRE_CORTO", length = 100)
    private String shortName;

    /** Description or purpose of the announcement. */
    @NotNull
    @Size(max = 400)
    @Column(name = "OBJETO_DESCRIPCION", length = 4000, nullable = false)
    private String description;

    /** Additional comments or notes regarding the announcement. */
    @Column(name = "COMENTARIO")
    private String comment;

    /** URL with additional details about the announcement. */
    @Size(max = 1000)
    @Column(name = "URL_DETALLE", length = 1000)
    private String detailUrl;

    /** Type of budget period for projects (e.g., month, year, or all). */
    @NotNull
    @Size(max = 5)
    @Column(name = "PERIODO_PRESUPUESTO", length = 5, nullable = false)
    private String budgetPeriodType;

    /** Total number of budget periods for the announcement. */
    @NotNull
    @Column(name = "TOTAL_PERIODOS_PRESUPUESTO", nullable = false)
    private Integer totalBudgetPeriods;

    /** Start date for the budget period in the announcement. */
    @NotNull
    @Column(name = "INICIO_PERIODO_PRESUPUESTO", nullable = false)
    private Date budgetStartDate;

    /** Selector for the type of registrar person. */
    @NotNull
    @Size(max = 1)
    @Column(name = "SELECTOR_REGISTRADOR", length = 1, nullable = false)
    private String registrarType;

    /** Maximum months allowed for formal project initiation. */
    @NotNull
    @Column(name = "MAX_INICIO_FORMAL", nullable = false)
    private Integer maxFormalStart;

    /** Maximum months allowed for extending the formal start of approved projects. */
    @NotNull
    @Column(name = "MAX_PRORROGA_INI_FORMAL", nullable = false)
    private Integer maxExtensionFormalStart;

    /** Maximum months allowed for extending the execution period of a project. */
    @NotNull
    @Column(name = "MAX_PRORROGA_EJECUCION", nullable = false)
    private Integer maxExecutionExtension;

    /** Indicator for allowing project execution to start with NN values ('YES' or 'NO'). */
    @NotNull
    @Size(max = 2)
    @Column(name = "INICIO_CON_NN", length = 2)
    private String allowExecutionWithNN;

    /** Time limit (in months) for suspending a project before its termination date. */
    @NotNull
    @Column(name = "TIEMPO_PARA_SUSPENDER", nullable = false)
    private Integer suspensionTimeLimit;

    /** Time limit (in months) for cancelling a project before its termination date. */
    @NotNull
    @Column(name = "TIEMPO_PARA_CANCELAR", nullable = false)
    private Integer cancellationTimeLimit;

    /** Maximum time (in months) allowed for partial delivery commitments. */
    @NotNull
    @Column(name = "MAX_TIE_ENT_COMPRO", nullable = false)
    private Integer maxPartialDeliveryTime;

    /** Maximum time (in months) for postponement of commitments. */
    @NotNull
    @Column(name = "MAX_TIE_APLAZ_COMPRO", nullable = false)
    private Integer maxCommitmentPostponementTime;

    /** Maximum eligible time (in months) for project execution. */
    @NotNull
    @Column(name = "MAX_TIEMPO_ELEGIBLE", nullable = false)
    private Integer maxEligibleTime;

    /** Name of the survey applied during the project call process. */
    @Size(max = 100)
    @Column(name = "NOMBRE_ENCUESTA", length = 100)
    private String surveyName;
}
