package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AerpuertoEstado {
    OPERATIVO("Operativo"),
    INACTIVO("Inactivo"),
    CERRADO("Cerrado"),
    EMERGENCIA("Emergencia"),
    EN_MANTENIMIENTO("En Mantenimiento");

    private final String descripcion;

    AerpuertoEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
