package com.airpatagonia.backend.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Tripulante {

    @NotNull
    private Empleado empleado;

    @NotNull
    private TripulantePuesto puesto;
}
