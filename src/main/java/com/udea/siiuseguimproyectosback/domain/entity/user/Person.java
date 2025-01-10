package com.udea.siiuseguimproyectosback.domain.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIIU_PERSONA_NATURAL")
public class Person {

    @Id
    @NotNull
    @Size(max = 20)
    @Column(name = "IDENTIFICADOR", nullable = false, updatable = false)
    private String id;

    @Size(max = 30)
    @Column(name = "TIPO_IDENTIFICACION")
    private String identificationType;

    @NotNull
    @Size(max = 100)
    @Column(name = "NOMBRE_PILA")
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "APELLIDO1")
    private String lastName1;

    @Size(max = 100)
    @Column(name = "APELLIDO2")
    private String lastName2;

    @NotNull
    @Size(max = 250)
    @Column(name = "CORREO_ELECTRONICO")
    private String email;

    @Size(max = 200)
    @Column(name = "DIRECCION")
    private String address;

    @NotNull
    @Size(max = 30)
    @Column(name = "TELEFONO")
    private String phone;

    @Size(max = 100)
    @Column(name = "IDENTIFICACION_LDAP")
    private String ldapIdentification;

    @Size(max = 30)
    @Column(name = "FAX")
    private String fax;

    @Column(name = "CONTINENTE")
    private Integer continent;

    @Column(name = "PAIS")
    private Integer country;

    @Column(name = "DEPARTAMENTO")
    private Integer department;

    @Column(name = "MUNICIPIO")
    private Integer municipality;

    @Column(name = "TEMPORAL")
    private Integer temporary;

    @Column(name = "FECHA_NACIMIENTO")
    private Date birthDate;

    @Column(name = "SEXO")
    private String gender;

    @Column(name = "ACTIVO")
    private Integer active;
}
