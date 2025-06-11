package com.airpatagonia.backend.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PagoTipo {
    EFECTIVO("Efectivo"),
    TARJETA("Tarjeta"),
    TRANSFERENCIA("Transferencia");

    private final String descripcion;

    PagoTipo(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }   
}
