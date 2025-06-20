package com.airpatagonia.backend.dtos;

import java.util.ArrayList;
import java.util.List;

import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.models.Empleado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripulanteDTO {
    private Long idEmpleado;
    private String nombre;
    private String apellido;
    private String nroDocumento;
    private TripulantePuesto puestoTripulante;
    private Long idVueloAsignado;

    public TripulanteDTO(Empleado empleado) {
        this.idEmpleado = empleado.getIdEmpleado();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.nroDocumento = empleado.getNroDocumento();
    }

    public List<TripulanteDTO> getTripulantesDTO(List<Empleado> empleados) {
        List<TripulanteDTO> tripulantesDTO = new ArrayList<>();
        for (Empleado empleado : empleados) {
            tripulantesDTO.add(new TripulanteDTO(empleado));
        }
        return tripulantesDTO;
    }

}
