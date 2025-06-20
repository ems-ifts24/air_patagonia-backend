package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PagoTipo {
    EFECTIVO("Efectivo"),
    TARJETA("Tarjeta"),
    TRANSFERENCIA("Transferencia");

    private final String descripcion;

    PagoTipo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }   
}
