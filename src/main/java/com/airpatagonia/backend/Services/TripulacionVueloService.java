package com.airpatagonia.backend.Services;

import com.airpatagonia.backend.Repositories.TripulacionVueloRepository;
import com.airpatagonia.backend.Repositories.TripulantePuestoRepository;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.models.Empleado;
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


    public List<Empleado> getTripulantesByVueloId(Long idVuelo) {
        return tripulacionVueloRepository.findByVuelo_IdVuelo(idVuelo)
            .stream()
            .map(TripulacionVuelo::getEmpleado)
            .collect(Collectors.toList());
    }

    public TripulacionVuelo asignarTripulanteAVuelo(TripulacionVuelo asignacion) {
        if (tripulacionVueloRepository.existsByVuelo_IdVueloAndEmpleado_IdEmpleado(
                asignacion.getVuelo().getIdVuelo(), 
                asignacion.getEmpleado().getIdEmpleado())) {
            throw new IllegalStateException("El empleado ya está asignado a este vuelo");
        }
        return tripulacionVueloRepository.save(asignacion);
    }

    public void eliminarAsignacion(Long idAsignacion) {
        tripulacionVueloRepository.deleteById(idAsignacion);
    }


    // TRIPULANTES PUESTOS
    public List<TripulantePuesto> getAllTripulantePuestos() {
        return tripulantePuestoRepository.findAll();
    }
}