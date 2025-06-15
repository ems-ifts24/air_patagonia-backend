package com.airpatagonia.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Persona {

    @Column(name = "Nombre", nullable = false)
    @NotNull
    protected String nombre;

    @Column(name = "Apellido", nullable = false)
    @NotNull
    protected String apellido;

    @Column(name = "Email", unique = true, nullable = false)
    @NotNull
    @Email
    protected String email;

    @Column(name = "TipoDocumento", nullable = false)
    @NotNull
    protected String tipoDocumento;

    @Column(name = "Documento", unique = true, nullable = false)
    @NotNull
    protected String nroDocumento;

    @ManyToOne
    @JoinColumn(name = "IdCiudad")
    @NotNull
    protected Ciudad ciudad;

    @Column(name = "Direccion")
    @NotNull
    protected String direccion;

    @Column(name = "Telefono")
    @NotNull
    protected String telefono;

    @Column(name = "FechaNacimiento")
    @NotNull
    protected LocalDateTime fechaNacimiento;


    protected String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}