package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

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

    // Indica que el valor de la propiedad será serializado como un valor simple en lugar de un objeto
    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }
}
