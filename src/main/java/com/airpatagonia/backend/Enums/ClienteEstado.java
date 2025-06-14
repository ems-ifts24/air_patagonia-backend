package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClienteEstado {
    ACTIVO("Activo"),
    BAJA("Baja"),
    BLOQUEADO("Bloqueado");

    private final String descripcion;

    ClienteEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
