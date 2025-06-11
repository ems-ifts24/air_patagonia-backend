package com.airpatagonia.backend.Enums;

public enum EmpleadoEstado {
    DISPONIBLE("Disponible"),
    ASIGNADO("Asignado"),
    LICENCIA("Licencia"),
    INACTIVO("Inactivo");
    ;

    private final String descripcion;

    EmpleadoEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
