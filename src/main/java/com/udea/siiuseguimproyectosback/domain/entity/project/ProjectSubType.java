package com.udea.siiuseguimproyectosback.domain.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_SUBTIPO_PROYECTO")
public class ProjectSubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_PROYECTO", referencedColumnName = "IDENTIFICADOR")
    private ProjectType projectType;

    @Column(name = "DESCRIPCION")
    private String description;

    @NotNull
    @Column(name = "INICIO_VIGENCIA")
    private Date startDate;

    @Column(name = "FIN_VIGENCIA")
    private Date endDate;

    @NotNull
    @Size(max = 16)
    @Column(name = "REGISTRADOR", nullable = false, length = 16)
    private String recorder;

    @NotNull
    @Size(max = 2)
    @Column(name = "SELECTOR_REGISTRADOR", nullable = false, length = 2)
    private String recorderSelector;

    @NotNull
    @Column(name = "FECHA_ULTIMO_CAMBIO")
    private Date lastChangeDate;
}
