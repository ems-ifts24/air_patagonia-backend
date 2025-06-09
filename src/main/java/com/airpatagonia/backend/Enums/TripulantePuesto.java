package com.airpatagonia.backend.Enums;

public enum TripulantePuesto {
    PILOTO("Piloto"),
    COPILOTO("Copiloto"),
    TRIPULANTE("Tripulante"),
    JEFE_CABINA("Jefe de Cabina"),
    AZAFATA("Azafata"),
    AUXILIAR_VUELO("Auxiliar de Vuelo"),
    INGENIERO_VUELO("Ingeniero de Vuelo");

    private final String descripcion;

    TripulantePuesto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
