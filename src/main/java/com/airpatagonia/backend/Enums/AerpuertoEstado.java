package com.airpatagonia.backend.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
