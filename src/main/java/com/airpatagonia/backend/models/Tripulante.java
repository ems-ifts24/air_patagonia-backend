package com.airpatagonia.backend.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.airpatagonia.backend.models.Empleado;


@Data
@NoArgsConstructor
@AllArgsConstructor
class Tripulante {

    @NotNull
    private Empleado empleado;

    @NotNull
    private TripulantePuesto puesto;
}
