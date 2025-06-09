package com.airpatagonia.backend.models;

import com.airpatagonia.backend.Enums.EmpleadoEstado;
import com.airpatagonia.backend.models.Persona;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
class Empleado extends Persona {
    private String legajo;
    private EmpleadoEstado estado;
}