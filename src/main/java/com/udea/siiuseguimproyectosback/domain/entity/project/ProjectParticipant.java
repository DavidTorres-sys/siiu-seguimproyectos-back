package com.udea.siiuseguimproyectosback.domain.entity.project;

import com.udea.siiuseguimproyectosback.domain.entity.user.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PARTICIPANTE_PROYECTO")
public class ProjectParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROYECTO", referencedColumnName = "CODIGO")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_NATURAL", referencedColumnName = "IDENTIFICACION")
    private Person responsible;

    @Size(max = 1)
    @Column(name = "SELECTOR_PERSONA")
    private String personSelector;

    @Size(max = 10)
    @Column(name = "VINCULACION_UDEA")
    private String udeaLink;

    @Size(max = 5)
    @Column(name = "VINCULACION_TIPO")
    private String linkType;

    @Size(max = 5)
    @Column(name = "VINCULACION_CLASE")
    private String linkClass;

    @Column(name = "COD_FACUL_PROG_APOY")
    private Long faculProgCode;

    @Column(name = "COD_PROGRAMA_APOYADO")
    private Long supportedProgramCode;

    @Column(name = "PORCENTAJE_PROG_ACAD")
    private Double academicProgPercentage;

    @Column(name = "ANONIMO")
    private Integer anonymous;

    @Column(name = "FECHA_INICIO")
    private Date startDate;

    @Column(name = "FECHA_FIN")
    private Date endDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROL_PARTICIPANTE_PROYECTO", referencedColumnName = "IDENTIFICADOR")
    private List<ProjectParticipantRol> projectParticipantRole;

    @Column(name = "INSTITUCION")
    private Long institution;

    @Column(name = "SELECTOR_INSTITUCION")
    private String institutionSelector;

    @Column(name = "GRUPO")
    private Long group;

    @Column(name = "DEDICACION_MESES")
    private Integer dedicationMonths;

    @Column(name = "DEDICACION_HORAS")
    private Integer dedicationHours;

    @Column(name = "DEDICACION_MESES_PLAN")
    private Integer dedicationMonthsPlan;

    @Column(name = "DEDICACION_HORAS_PLAN")
    private Integer dedicationHoursPlan;

    @Column(name = "PORCENTAJE_BENEFICIOS")
    private Double benefitsPercentage;

    @Column(name ="FUNCION")
    private String function;

    @Column(name = "OBSERVACION")
    private String observation;

    @Column(name = "USUARIO_CREA")
    private String userCreate;

    @Column(name = "FECHA_CREA")
    private Timestamp dateCreate;

    @Column(name = "USUARIO_ACTUALIZA")
    private String userUpdate;

    @Column(name = "FECHA_ACTUALIZA")
    private Timestamp dateUpdate;

    @Column(name = "CODIGO_DEPENDENCIA")
    private String dependencyCode;

    @Column(name = "NOMBRE_DEPENDENCIA")
    private String dependencyName;

    @Column(name = "USUARIO_MODIFICA")
    private String userModify;

    @Column(name = "FECHA_MODIFICA")
    private Timestamp dateModify;

    @Column(name = "NOMBRE_COMPLETO")
    private String fullName;

    @Column(name = "CORREO")
    private String email;

    // Reference to the smap_nota_aclaratoria table where the text of the notes is located.
    // TODO: CREATE TABLE
    @Column(name = "NOTA_ACLARATORIA")
    private Integer clarifyingNote;

    @Column(name = "NOTA_ACLARATORIA_GENERAL")
    private String generalClarifyingNote;

    @Column(name = "TIPO_CONTRATO")
    private String contractType;

    @Column(name = "DETALLE_CONTRATO")
    private String contractDetail;

    @Column(name = "NOMBRE_PROGRAMA_EXTERNO")
    private String externalProgramName;

    @Column(name = "RESUMEN_ACTIVIDADES")
    private String activitiesSummary;

    @Column(name = "CONTACTO_PRINCIPAL")
    private String mainContact;

    @Column(name = "DEPENDENCIA")
    private String dependency;

    @Column(name = "CONFIRMADO")
    private Integer confirmed;

    @Column(name = "CONFIRMADO_CONVENIO")
    private Integer confirmedAgreement;
}
