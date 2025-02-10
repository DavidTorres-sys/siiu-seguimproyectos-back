package com.udea.siiuseguimproyectosback.domain.entity.project;

import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import com.udea.siiuseguimproyectosback.domain.entity.user.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Represents a project within the system.
 * <p>
 * The {@link Project} entity is mapped to the "SIIU_PROYECTO" table in the database and contains various attributes
 * describing the project's characteristics, such as its code, participants, announcement, selection process, project type,
 * and status. Additionally, it contains related entities such as {@link Person} (responsible person), {@link Announcement},
 * and {@link SelectionProcess}.
 * </p>
 *
 * <h3>Attributes</h3>
 * <ul>
 *   <li><b>code:</b> The unique code for the project (max length 20).</li>
 *   <li><b>participants:</b> A list of participants associated with the project.</li>
 *   <li><b>announcement:</b> The {@link Announcement} related to the project.</li>
 *   <li><b>announcementMode:</b> Indicates the mode of the announcement.</li>
 *   <li><b>selectionProcess:</b> The {@link SelectionProcess} associated with the project.</li>
 *   <li><b>projectSubtype:</b> The {@link ProjectSubType} associated with the project.</li>
 *   <li><b>currentStage:</b> The current stage of the project.</li>
 *   <li><b>currentAdministrativeInstance:</b> The current administrative instance of the project.</li>
 *   <li><b>administrativeCenter:</b> The administrative center associated with the project.</li>
 *   <li><b>sendCenterDate:</b> The date the project was sent to the administrative center.</li>
 *   <li><b>responsible:</b> The responsible {@link Person} for the project.</li>
 *   <li><b>responsibleSelector:</b> A selector for the responsible person (a single character).</li>
 *   <li><b>sectional:</b> The sectional code for the project.</li>
 *   <li><b>sectionalSelector:</b> A selector for the sectional code (a single character).</li>
 *   <li><b>status:</b> The current status of the project (max length 31).</li>
 *   <li><b>approvalRejectionDate:</b> The date of approval or rejection for the project.</li>
 *   <li><b>registrationDate:</b> The date when the project was registered.</li>
 *   <li><b>shortName:</b> A short name for the project (max length 200).</li>
 *   <li><b>fullName:</b> The full name of the project (max length 200).</li>
 *   <li><b>keywords:</b> A set of keywords associated with the project (max length 200).</li>
 *   <li><b>duration:</b> The duration of the project in months.</li>
 *   <li><b>executionPlace:</b> The place where the project is executed (max length 100).</li>
 *   <li><b>currency:</b> The currency used for the project (max length 3).</li>
 *   <li><b>pendingBudgetAdjustment:</b> Indicates whether the project has a pending budget adjustment.</li>
 *   <li><b>schedulePeriod:</b> The period of the project schedule (max length 6).</li>
 *   <li><b>notifiedRp:</b> Indicates if the responsible person has been notified.</li>
 *   <li><b>isJuryEligible:</b> Indicates whether the project is eligible for jury evaluation.</li>
 *   <li><b>projectClass:</b> The class of the project.</li>
 *   <li><b>projectLevel:</b> The level of the project.</li>
 *   <li><b>projectSubLevel:</b> The sub-level of the project as an instance of {@link ProjectSubLevel}.</li>
 *   <li><b>projectTypeMacro:</b> The macro type of the project.</li>
 *   <li><b>requiresBioethicsApproval:</b> Indicates whether the project requires bioethics approval.</li>
 *   <li><b>bioethicsCommittee:</b> The bioethics committee associated with the project.</li>
 *   <li><b>pendingCenterReview:</b> Indicates whether the project is pending center review.</li>
 *   <li><b>id:</b> The unique identifier for the project in the database.</li>
 * </ul>
 *
 * <p>
 * This class is annotated with JPA annotations to enable persistence and mapping to a relational database.
 * The {@link Data} annotation from Lombok automatically generates getters, setters, equals, hashcode, and toString methods.
 * The {@link NoArgsConstructor} annotation from Lombok generates a no-arguments constructor for the class.
 * </p>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PROYECTO")
public class Project {

    /**
     * The unique code for the project.
     * <p>
     * This is the primary key for the project entity and is constrained to be no longer than 20 characters.
     * </p>
     */
    @Id
    @Size(max = 20)
    @Column(name = "CODIGO", nullable = false, length = 20)
    private String code;

    /**
     * A list of participants associated with the project.
     * <p>
     * This is a one-to-many relationship with the {@link ProjectParticipant} entity.
     * The relationship is mapped by the "project" field in the {@link ProjectParticipant} entity.
     * </p>
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProjectParticipant> participants;

    /**
     * The {@link Announcement} related to the project.
     * <p>
     * This is a many-to-one relationship with the {@link Announcement} entity.
     * The "CONVOCATORIA" field in the project is a foreign key that references the "IDENTIFICADOR" column
     * in the {@link Announcement} table.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONVOCATORIA", referencedColumnName = "IDENTIFICADOR")
    private Announcement announcement;

    /**
     * The mode of the announcement.
     * <p>
     * Represents the mode of the announcement related to the project. This value is optional.
     * </p>
     */
    @Column(name = "MODALIDAD_CONVOCATORIA")
    private Long announcementMode;

    /**
     * The {@link SelectionProcess} associated with the project.
     * <p>
     * This is a many-to-one relationship with the {@link SelectionProcess} entity.
     * The "PROCESO_SELECCION" field in the project is a foreign key that references the "IDENTIFICADOR" column
     * in the {@link SelectionProcess} table.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROCESO_SELECCION", referencedColumnName = "IDENTIFICADOR")
    private SelectionProcess selectionProcess;

    /**
     * The {@link ProjectSubType} associated with the project.
     * <p>
     * This is a many-to-one relationship with the {@link ProjectSubType} entity.
     * The "SUBTIPO_PROYECTO" field in the project is a foreign key that references the "IDENTIFICADOR" column
     * in the {@link ProjectSubType} table.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBTIPO_PROYECTO", referencedColumnName = "IDENTIFICADOR")
    private ProjectSubType projectSubtype;

    /**
     * The current stage of the project.
     * <p>
     * This represents the stage of the project in its lifecycle. It is stored as an integer.
     * </p>
     */
    @Column(name = "ETAPA_ACTUAL")
    private Integer currentStage;

    /**
     * The current administrative instance of the project.
     * <p>
     * This represents the administrative instance the project is currently in. It is stored as an integer.
     * </p>
     */
    @Column(name = "INSTANCIA_ADMTIVA_ACTUAL")
    private Integer currentAdministrativeInstance;

    /**
     * The administrative center associated with the project.
     * <p>
     * This represents the administrative center for the project. It is stored as a long value.
     * </p>
     */
    @Column(name = "CENTRO_GESTION")
    private Long administrativeCenter;

    /**
     * The date the project was sent to the administrative center.
     * <p>
     * This date represents when the project was sent to the administrative center for processing.
     * </p>
     */
    @Column(name = "FECHA_ENVIO_CENTRO")
    private LocalDate sendCenterDate;

    /**
     * The responsible {@link Person} for the project.
     * <p>
     * This is a many-to-one relationship with the {@link Person} entity.
     * The "RESPONSABLE" field in the project is a foreign key that references the "IDENTIFICACION" column
     * in the {@link Person} table.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESPONSABLE", referencedColumnName = "IDENTIFICACION")
    private Person responsible;

    /**
     * A selector for the responsible person.
     * <p>
     * This is a one-character field indicating the selector for the responsible person.
     * </p>
     */
    @NotNull
    @Size(max = 1)
    @Column(name = "SELECTOR_RESPONSABLE", nullable = false, length = 1)
    private String responsibleSelector;

    /**
     * The sectional code for the project.
     * <p>
     * This is an optional field that stores the sectional code associated with the project.
     * </p>
     */
    @Size(max = 8)
    @Column(name = "SECCIONAL", length = 8)
    private String sectional;

    /**
     * A selector for the sectional code.
     * <p>
     * This is an optional one-character field indicating the selector for the sectional code.
     * </p>
     */
    @Size(max = 1)
    @Column(name = "SELECTOR_SECCIONAL", length = 1)
    private String sectionalSelector;

    /**
     * The current status of the project.
     * <p>
     * This represents the current status of the project. It is a required field with a maximum length of 31 characters.
     * </p>
     */
    @NotNull
    @Size(max = 31)
    @Column(name = "ESTADO", nullable = false, length = 31)
    private String status;

    /**
     * The date of approval or rejection for the project.
     * <p>
     * This date represents when the project was either approved or rejected.
     * </p>
     */
    @Column(name = "FECHA_APROBACION_RECHAZO")
    private LocalDate approvalRejectionDate;

    /**
     * The date when the project was registered.
     * <p>
     * This date represents when the project was first registered in the system.
     * </p>
     */
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDate registrationDate;

    /**
     * The short name for the project.
     * <p>
     * This is a required field with a maximum length of 200 characters.
     * </p>
     */
    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE_CORTO", nullable = false, length = 200)
    private String shortName;

    /**
     * The full name of the project.
     * <p>
     * This is a required field with a maximum length of 200 characters.
     * </p>
     */
    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPLETO", nullable = false, length = 200)
    private String fullName;

    /**
     * A set of keywords associated with the project.
     * <p>
     * This is a required field with a maximum length of 200 characters.
     * </p>
     */
    @NotNull
    @Size(max = 200)
    @Column(name = "PALABRAS_CLAVES", nullable = false, length = 200)
    private String keywords;

    /**
     * The duration of the project in months.
     * <p>
     * This is a required field.
     * </p>
     */
    @NotNull
    @Column(name = "DURACION", nullable = false)
    private Integer duration;

    /**
     * The place where the project is executed.
     * <p>
     * This is a required field with a maximum length of 100 characters.
     * </p>
     */
    @NotNull
    @Size(max = 100)
    @Column(name = "LUGAR_EJECUCION", nullable = false, length = 100)
    private String executionPlace;

    /**
     * The currency used for the project.
     * <p>
     * This is a required field with a maximum length of 3 characters.
     * </p>
     */
    @NotNull
    @Size(max = 3)
    @Column(name = "MONEDA", nullable = false, length = 3)
    private String currency;

    /**
     * Indicates whether the project has a pending budget adjustment.
     * <p>
     * This is a required field and is stored as an integer.
     * </p>
     */
    @NotNull
    @Column(name = "PENDIENTE_AJUSTE_PPTO", nullable = false)
    private Integer pendingBudgetAdjustment;

    /**
     * The period of the project schedule.
     * <p>
     * This is an optional field with a maximum length of 6 characters.
     * </p>
     */
    @Size(max = 6)
    @Column(name = "PERIODO_CRONOGRAMA", length = 6)
    private String schedulePeriod;

    /**
     * Indicates if the responsible person has been notified.
     * <p>
     * This is an optional one-character field indicating whether the responsible person has been notified.
     * </p>
     */
    @Size(max = 1)
    @Column(name = "NOTIFICADO_RP", length = 1)
    private String notifiedRp;

    /**
     * Indicates whether the project is eligible for jury evaluation.
     * <p>
     * This is a required field and is stored as an integer.
     * </p>
     */
    @NotNull
    @Column(name = "ES_ELEGIBLE_JURADO", nullable = false)
    private Integer isJuryEligible;

    /**
     * The class of the project.
     * <p>
     * This is an optional field stored as an integer.
     * </p>
     */
    @Column(name = "CLASE_PROYECTO")
    private Integer projectClass;

    /**
     * The level of the project.
     * <p>
     * This is an optional field stored as an integer.
     * </p>
     */
    @Column(name = "NIVEL_PROYECTO")
    private Integer projectLevel;

    /**
     * The sub-level of the project.
     * <p>
     * This is a many-to-one relationship with the {@link ProjectSubLevel} entity.
     * The "SUBNIVEL_PROYECTO" field in the project is a foreign key that references the "SUBNIVEL_PROYECTO" column
     * in the {@link ProjectSubLevel} table.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBNIVEL_PROYECTO", referencedColumnName = "SUBNIVEL_PROYECTO")
    private ProjectSubLevel projectSubLevel;

    /**
     * The macro type of the project.
     * <p>
     * This is an optional field stored as an integer.
     * </p>
     */
    @Column(name = "TIPO_PROYECTO_MACRO")
    private Integer projectTypeMacro;

    /**
     * Indicates whether the project requires bioethics approval.
     * <p>
     * This is an optional field stored as an integer.
     * </p>
     */
    @Column(name = "REQUIERE_AVAL_BIOETICA")
    private Integer requiresBioethicsApproval;

    /**
     * The bioethics committee associated with the project.
     * <p>
     * This is an optional field stored as an integer.
     * </p>
     */
    @Column(name = "COMITE_BIOETICA")
    private Integer bioethicsCommittee;

    /**
     * Indicates whether the project is pending center review.
     * <p>
     * This is an optional one-character field indicating whether the project is pending review by the center.
     * </p>
     */
    @Size(max = 1)
    @Column(name = "PENDIENTE_REVISION_CENTRO", length = 1)
    private String pendingCenterReview;

    /**
     * The unique identifier for the project.
     * <p>
     * This is the primary key identifier for the project entity.
     * </p>
     */
    @Column(name = "IDENTIFICADOR")
    private Long id;
}
