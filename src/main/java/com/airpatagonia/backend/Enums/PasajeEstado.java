package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PasajeEstado {
    VIGENTE("Vigente"),
    MODIFICADO("Modificado"),
    ABIERTO("Abierto"),
    CANCELADO("Cancelado");

    private final String descripcion;

    PasajeEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
