package com.airpatagonia.backend.models;

import com.airpatagonia.backend.Enums.TripulantePuesto;
import com.airpatagonia.backend.models.Empleado;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Tripulante {
    Empleado empleado;
    private TripulantePuesto puesto;
}
