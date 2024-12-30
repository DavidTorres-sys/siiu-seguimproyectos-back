package com.udea.siiuseguimproyectosback.domain.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_SUBNIVEL_PROYECTO")
public class ProjectSubLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBNIVEL_PROYECTO", nullable = false, updatable = false)
    private Long subLevelProject;

    @NotNull
    @Column(name = "IDENTIFICADOR", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "NOMBRE", nullable = false)
    private String name;

    @NotNull
    @Size(max = 500)
    @Column(name = "DESCRIPCION", nullable = false)
    private String description;

    @NotNull
    @Size(max = 20)
    @Column(name = "TIPONIVEL", nullable = false)
    private String levelType;

    @NotNull
    @Column(name = "LISTAR_CON_NIVELES", nullable = false)
    private Integer listWithLevels;
}

