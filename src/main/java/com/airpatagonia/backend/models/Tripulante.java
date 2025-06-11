package com.airpatagonia.backend.models;

import com.airpatagonia.backend.models.Empleado;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Tripulante {

    private Empleado empleado;

    private TripulantePuesto puesto;
}
