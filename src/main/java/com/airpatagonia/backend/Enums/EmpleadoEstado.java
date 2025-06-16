package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EmpleadoEstado {
    DISPONIBLE("Disponible"),
    ASIGNADO("Asignado"),
    LICENCIA("Licencia"),
    INACTIVO("Inactivo");
    ;

    private final String descripcion;

    EmpleadoEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
