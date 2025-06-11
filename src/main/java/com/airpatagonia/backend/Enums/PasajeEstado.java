package com.airpatagonia.backend.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PasajeEstado {
    VIGENTE("Vigente"),
    MODIFICADO("Modificado"),
    ABIERTO("Abierto"),
    CANCELADO("Cancelado");

    private final String descripcion;

    PasajeEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
