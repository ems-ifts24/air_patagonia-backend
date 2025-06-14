package com.airpatagonia.backend.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PasajeroEmpleado extends Pasajero {
    @ManyToOne
    @JoinColumn(name = "IdEmpleado")
    private Empleado empleado;
}
