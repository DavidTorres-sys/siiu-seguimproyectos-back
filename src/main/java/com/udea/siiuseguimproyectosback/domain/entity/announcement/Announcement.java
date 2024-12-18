package com.udea.siiuseguimproyectosback.domain.entity.announcement;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    /**
     * Unique identifier for the announcement.
     * <p>
     * This is an auto-generated value managed by the database. It uniquely identifies each announcement record.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    /**
     * Code of the financier providing the funds for the announcement.
     * <p>
     * This field stores a short code (maximum 20 characters) that identifies the financier entity.
     * </p>
     */
    @Column(name = "CODIGO_FINANCIADOR", length = 20)
    private String financierCode;

    /**
     * Reference to the selection process used for the projects in the announcement.
     * <p>
     * This is a numeric value (maximum 10 digits) that links the announcement to its selection process.
     * This field cannot be {@code null}.
     * </p>
     */
    @Column(name = "PROCESO_SELECCION", nullable = false, length = 10)
    private Integer selectionProcess;

    /**
     * Reference to the person or entity who registered the announcement.
     * <p>
     * This field holds an alphanumeric identifier (maximum 16 characters) of the registrar.
     * This field cannot be {@code null}.
     * </p>
     */
    @Column(name = "REGISTRADOR", nullable = false, length = 16)
    private String registrar;

    /**
     * Date when the announcement was created.
     * <p>
     * This field indicates when the announcement record was first added to the system. It is mandatory.
     * </p>
     */
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date creationDate;

    /**
     * Date when the announcement was published.
     * <p>
     * If this field is {@code null}, the announcement is considered to be in a draft state.
     * </p>
     */
    @Column(name = "FECHA_PUBLICACION")
    private Date publicationDate;

    /**
     * Date of the last modification made to the announcement.
     * <p>
     * This field records the most recent date when any changes were made to the announcement.
     * It ensures proper version control.
     * </p>
     */
    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    private Date lastModifiedDate;

    /**
     * Date when the announcement closes for project submissions.
     * <p>
     * This field defines the deadline for submitting proposals associated with the announcement.
     * </p>
     */
    @Column(name = "FECHA_CIERRE")
    private Date closingDate;

    /**
     * Date when the announcement opens for project submissions.
     * <p>
     * Proposals can be submitted only after this date.
     * </p>
     */
    @Column(name = "FECHA_APERTURA")
    private Date openingDate;

    /**
     * Date when the results of the announcement are published.
     * <p>
     * This field records the date when the outcome of the announcement (e.g., selected projects) is shared publicly.
     * </p>
     */
    @Column(name = "FECHA_RESULTADOS")
    private Date resultsDate;

    /**
     * Full name of the announcement.
     * <p>
     * This descriptive name (up to 400 characters) helps users identify the purpose or title of the announcement.
     * </p>
     */
    @Column(name = "NOMBRE", length = 400, nullable = false)
    private String name;

    /**
     * Short name of the announcement.
     * <p>
     * This field allows for a shorter version (up to 100 characters) of the announcement name.
     * </p>
     */
    @Column(name = "NOMBRE_CORTO", length = 100)
    private String shortName;

    /**
     * Description or purpose of the announcement.
     * <p>
     * This field contains a detailed explanation (up to 4000 characters) of the announcement's purpose, scope,
     * or objectives.
     * </p>
     */
    @Column(name = "OBJETO_DESCRIPCION", length = 4000, nullable = false)
    private String description;

    /**
     * Additional comments or notes regarding the announcement.
     * <p>
     * This optional field can include any extra information or annotations relevant to the announcement.
     * </p>
     */
    @Column(name = "COMENTARIO")
    private String comment;

    /**
     * URL providing additional details about the announcement.
     * <p>
     * This field stores a web link (up to 1000 characters) for further reference.
     * </p>
     */
    @Column(name = "URL_DETALLE", length = 1000)
    private String detailUrl;

    /**
     * Type of budget period for the announcement.
     * <p>
     * Possible values include 'month', 'year', or 'all'. This field determines how the budget periods are classified.
     * </p>
     */
    @Column(name = "PERIODO_PRESUPUESTO", length = 5, nullable = false)
    private String budgetPeriodType;

    /**
     * Total number of budget periods applicable to the announcement.
     * <p>
     * This numeric field defines how many budget periods are being considered (e.g., 12 months).
     * </p>
     */
    @Column(name = "TOTAL_PERIODOS_PRESUPUESTO", precision = 4, scale = 0, nullable = false)
    private Integer totalBudgetPeriods;

    /**
     * Start date for the budgeting period.
     * <p>
     * The date when the first budget period begins for the projects associated with this announcement.
     * </p>
     */
    @Column(name = "INICIO_PERIODO_PRESUPUESTO", nullable = false)
    private Date budgetStartDate;

    /**
     * Selector to identify the type of registrar (e.g., natural or organizational).
     * <p>
     * Accepts a single character input, typically 'H' for humans.
     * </p>
     */
    @Column(name = "SELECTOR_REGISTRADOR", length = 1, nullable = false)
    private String registrarType;
}
