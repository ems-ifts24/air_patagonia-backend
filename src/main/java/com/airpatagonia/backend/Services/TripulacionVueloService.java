package com.airpatagonia.backend.services;

import com.airpatagonia.backend.exceptions.ResourceAlreadyExistsException;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.repositories.EmpleadoRepository;
import com.airpatagonia.backend.repositories.TripulacionVueloRepository;
import com.airpatagonia.backend.repositories.TripulantePuestoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripulacionVueloService {
    
    @Autowired
    private TripulacionVueloRepository tripulacionVueloRepository;

    @Autowired
    private TripulantePuestoRepository tripulantePuestoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public List<Empleado> getTripulantesByVueloId(Long idVuelo) {
        return tripulacionVueloRepository.findByVuelo_IdVuelo(idVuelo)
            .stream()
            .map(TripulacionVuelo::getEmpleado)
            .collect(Collectors.toList());
    }

    public Empleado asignarTripulanteAVuelo(TripulacionVuelo asignacion) {
        if (tripulacionVueloRepository.existsByVuelo_IdVueloAndEmpleado_IdEmpleado(
                asignacion.getVuelo().getIdVuelo(), 
                asignacion.getEmpleado().getIdEmpleado())) {
            throw new ResourceAlreadyExistsException("El empleado ya está asignado a este vuelo");
        }

        // Guardar la asignacion
        TripulacionVuelo asignacionGuardada = tripulacionVueloRepository.save(asignacion);

        // Devolver la asignacion guardada con sus relaciones completas
        return empleadoRepository.findById(asignacionGuardada.getEmpleado().getIdEmpleado()).get();
    }

    public void eliminarAsignacion(Long idAsignacion) {
        tripulacionVueloRepository.deleteById(idAsignacion);
    }


    // TRIPULANTES PUESTOS
    public List<TripulantePuesto> getAllTripulantePuestos() {
        return tripulantePuestoRepository.findAll();
    }
}