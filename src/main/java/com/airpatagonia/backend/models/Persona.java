package com.airpatagonia.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Persona {

    @Column(name = "Nombre", nullable = false)
    protected String nombre;

    @Column(name = "Apellido", nullable = false)
    protected String apellido;

    @Column(name = "Email", unique = true, nullable = false)
    protected String email;

    @Column(name = "TipoDocumento", nullable = false)
    protected String tipoDocumento;

    @Column(name = "Documento", unique = true, nullable = false)
    protected String nroDocumento;

    @ManyToOne
    @JoinColumn(name = "IdCiudad")
    protected Ciudad ciudad;

    @Column(name = "Direccion")
    protected String direccion;

    @Column(name = "Telefono")
    protected String telefono;

    @Column(name = "FechaNacimiento")
    protected LocalDateTime fechaNacimiento;


    protected String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}