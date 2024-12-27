package com.udea.siiuseguimproyectosback.domain.entity.project;

import com.udea.siiuseguimproyectosback.domain.entity.announcement.Announcement;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PROYECTO")
public class Project {

    @Id
    @Size(max = 20)
    @Column(name = "CODIGO", nullable = false, length = 20)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONVOCATORIA", referencedColumnName = "IDENTIFICADOR")
    private Announcement announcement;

    @Column(name = "MODALIDAD_CONVOCATORIA")
    private Long announcementMode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROCESO_SELECCION", referencedColumnName = "IDENTIFICADOR")
    private SelectionProcess selectionProcess;

    @Column(name = "SUBTIPO_PROYECTO")
    private Integer projectSubtype;

    @Column(name = "ETAPA_ACTUAL")
    private Integer currentStage;

    @Column(name = "INSTANCIA_ADMTIVA_ACTUAL")
    private Integer currentAdministrativeInstance;

    @Column(name = "CENTRO_GESTION")
    private Long administrativeCenter;

    @Column(name = "FECHA_ENVIO_CENTRO")
    private LocalDate sendCenterDate;

    @NotNull
    @Size(max = 16)
    @Column(name = "RESPONSABLE", nullable = false, length = 16)
    private String responsible;

    @NotNull
    @Size(max = 1)
    @Column(name = "SELECTOR_RESPONSABLE", nullable = false, length = 1)
    private String responsibleSelector;

    @Size(max = 8)
    @Column(name = "SECCIONAL", length = 8)
    private String sectional;

    @Size(max = 1)
    @Column(name = "SELECTOR_SECCIONAL", length = 1)
    private String sectionalSelector;

    @NotNull
    @Size(max = 31)
    @Column(name = "ESTADO", nullable = false, length = 31)
    private String status;

    @Column(name = "FECHA_APROBACION_RECHAZO")
    private LocalDate approvalRejectionDate;

    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDate registrationDate;

    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE_CORTO", nullable = false, length = 200)
    private String shortName;

    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPLETO", nullable = false, length = 200)
    private String fullName;

    @NotNull
    @Size(max = 200)
    @Column(name = "PALABRAS_CLAVES", nullable = false, length = 200)
    private String keywords;

    @NotNull
    @Column(name = "DURACION", nullable = false)
    private Integer duration;

    @NotNull
    @Size(max = 100)
    @Column(name = "LUGAR_EJECUCION", nullable = false, length = 100)
    private String executionPlace;

    @NotNull
    @Size(max = 3)
    @Column(name = "MONEDA", nullable = false, length = 3)
    private String currency;

    @NotNull
    @Column(name = "PENDIENTE_AJUSTE_PPTO", nullable = false)
    private Integer pendingBudgetAdjustment;

    @Size(max = 6)
    @Column(name = "PERIODO_CRONOGRAMA", length = 6)
    private String schedulePeriod;

    @Size(max = 1)
    @Column(name = "NOTIFICADO_RP", length = 1)
    private String notifiedRp;

    @NotNull
    @Column(name = "ES_ELEGIBLE_JURADO", nullable = false)
    private Integer isJuryEligible;

    @Column(name = "CLASE_PROYECTO")
    private Integer projectClass;

    @Column(name = "NIVEL_PROYECTO")
    private Integer projectLevel;

//    @Column(name = "SUBNIVEL_PROYECTO")
//    private Integer projectSublevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBNIVEL_PROYECTO", referencedColumnName = "SUBNIVEL_PROYECTO")
    private SubLevelProject subLevelProject;

    @Column(name = "TIPO_PROYECTO_MACRO")
    private Integer projectTypeMacro;

    @Column(name = "REQUIERE_AVAL_BIOETICA")
    private Integer requiresBioethicsApproval;

    @Column(name = "COMITE_BIOETICA")
    private Integer bioethicsCommittee;

    @Size(max = 1)
    @Column(name = "PENDIENTE_REVISION_CENTRO", length = 1)
    private String pendingCenterReview;
}
