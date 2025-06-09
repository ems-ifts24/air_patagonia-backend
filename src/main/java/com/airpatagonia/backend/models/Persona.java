package com.airpatagonia.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String tipoDocumento;
    private String nroDocumento;
    private String pais;
    private String ciudad;
    private String direccion;
    private String telefono;

    protected String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}