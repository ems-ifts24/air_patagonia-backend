package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PagoEstado {
    PENDIENTE("Pendiente"),
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado");

    private final String descripcion;

    PagoEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
