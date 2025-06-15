package com.airpatagonia.backend.services;

import com.airpatagonia.backend.enums.EmpleadoEstado;
import com.airpatagonia.backend.exceptions.ResourceAlreadyExistsException;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.repositories.EmpleadoRepository;
import com.airpatagonia.backend.repositories.TripulacionVueloRepository;
import com.airpatagonia.backend.repositories.TripulantePuestoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripulacionVueloService {

    private static final Logger logger = LoggerFactory.getLogger(TripulacionVueloService.class);

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

    @Transactional
    public Empleado asignarTripulanteAVuelo(TripulacionVuelo asignacion) {
        if (tripulacionVueloRepository.existsByVuelo_IdVueloAndEmpleado_IdEmpleado(
                asignacion.getVuelo().getIdVuelo(), 
                asignacion.getEmpleado().getIdEmpleado())) {
            throw new ResourceAlreadyExistsException("El empleado ya está asignado a este vuelo");
        }

        Empleado empleado = empleadoRepository.findById(asignacion.getEmpleado().getIdEmpleado()).get();
        if (EmpleadoEstado.DISPONIBLE != empleado.getEstadoEmpleado()) {
            throw new ResourceAlreadyExistsException("El empleado no está disponible.");
        }

        // Guardar la asignacion
        TripulacionVuelo asignacionGuardada = tripulacionVueloRepository.save(asignacion);

        // Cambiar el estado del empleado
        empleado.setEstadoEmpleado(EmpleadoEstado.ASIGNADO);
        empleadoRepository.save(empleado);

        // Devolver la asignacion guardada con sus relaciones completas
        return empleadoRepository.findById(asignacionGuardada.getEmpleado().getIdEmpleado()).get();
    }

    public void quitarTripulante(Long idVuelo, Long idEmpleado) {
        tripulacionVueloRepository.deleteTripulacionVueloByVuelo_IdVueloAndEmpleado_IdEmpleado(idVuelo, idEmpleado);
    }


    // TRIPULANTES PUESTOS
    public List<TripulantePuesto> getAllTripulantePuestos() {
        return tripulantePuestoRepository.findAll();
    }

    // Elimino la tripulacion del vuelo
    @Transactional
    public void deleteTripulacionVueloByVueloId(Long idVuelo) {
        DisponibilizarEmpleados(idVuelo);
        tripulacionVueloRepository.deleteAllByVuelo_IdVuelo(idVuelo);
    }

    private void DisponibilizarEmpleados(Long idVuelo) {
        logger.info("Disponibilizando empleados del vuelo con id: {}", idVuelo);
        List<Empleado> empleados = getTripulantesByVueloId(idVuelo);
        logger.debug("Empleados obtenidos exitosamente: {}", empleados);
        
        if (!empleados.isEmpty()) {
            for (Empleado empleado : empleados) {
                logger.debug("Disponibilizando empleado con id: {}", empleado.getIdEmpleado());
                empleado.setEstadoEmpleado(EmpleadoEstado.DISPONIBLE);
                empleadoRepository.save(empleado);
            }
        }
    }

}