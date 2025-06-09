package com.airpatagonia.backend.Enums;

public enum AvionEstado {
    BAJA("Baja"),
    DISPONIBLE("Disponible"),
    RESERVADO("Reservado"),
    EN_VUELO("En vuelo"),
    EN_MANTENIMIENTO("En mantenimiento");

    private final String descripcion;

    AvionEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
