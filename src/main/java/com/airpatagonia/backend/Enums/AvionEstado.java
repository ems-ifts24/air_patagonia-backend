package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
