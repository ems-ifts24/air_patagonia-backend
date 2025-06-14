package com.airpatagonia.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.airpatagonia.backend.models.Empleado;


@Data
@NoArgsConstructor
@AllArgsConstructor
class Tripulante {

    private Empleado empleado;

    private TripulantePuesto puesto;
}
