package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PasajeroCategoria {
    TURISTA("Turista"),
    BUSINESS("Business"),
    PRIMERA_CLASE("Primera Clase");

    private final String descripcion;

    PasajeroCategoria(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
