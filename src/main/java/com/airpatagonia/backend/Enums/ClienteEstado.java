package com.airpatagonia.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClienteEstado {
    ACTIVO("Activo"),
    BAJA("Baja"),
    BLOQUEADO("Bloqueado");

    private final String descripcion;

    ClienteEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
