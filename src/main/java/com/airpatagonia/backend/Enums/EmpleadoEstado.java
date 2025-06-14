package com.airpatagonia.backend.enums;

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
