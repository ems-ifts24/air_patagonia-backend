package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

// Indica que el enum se serializa como un objeto JSON completo (con nombre y descripcion)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VueloEstado {
    PROGRAMADO("Programado"),
    EMBARCANDO("Embarcando"),
    REPROGRAMADO("Reprogramado"),
    CERRADO("Cerrado"),
    EN_VUELO("En vuelo"),
    FINALIZADO("Finalizado"),
    DEMORADO("Demorado"),
    CANCELADO("Cancelado"),
    BAJA_LOGICA("Baja logica");

    private final String descripcion;

    VueloEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}