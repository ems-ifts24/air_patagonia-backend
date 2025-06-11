package com.airpatagonia.backend.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PasajeroCategoria {
    TURISTA("Turista"),
    BUSINESS("Business"),
    PRIMERA_CLASE("Primera Clase");

    private final String descripcion;

    PasajeroCategoria(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
