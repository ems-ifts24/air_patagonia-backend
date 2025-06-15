package com.airpatagonia.backend.enums;

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

    public String getDescripcion() {
        return descripcion;
    }
}