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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import com.airpatagonia.backend.dtos.TripulanteDTO;

@Service
public class TripulacionVueloService {

    private static final Logger logger = LoggerFactory.getLogger(TripulacionVueloService.class);

    @Autowired
    private TripulacionVueloRepository tripulacionVueloRepository;

    @Autowired
    private TripulantePuestoRepository tripulantePuestoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public List<TripulacionVuelo> getTripulantesByVueloId(Long idVuelo) {
        return tripulacionVueloRepository.findByVuelo_IdVuelo(idVuelo);
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

    public TripulacionVuelo updateTripulante(TripulacionVuelo tripulacionVuelo) {
        logger.info("Actualizando tripulante {} del vuelo {}", tripulacionVuelo.getEmpleado().getIdEmpleado(), tripulacionVuelo.getVuelo().getIdVuelo());
        TripulacionVuelo tripulacionVueloUpdated = tripulacionVueloRepository.findByVuelo_IdVueloAndEmpleado_IdEmpleado(tripulacionVuelo.getVuelo().getIdVuelo(), tripulacionVuelo.getEmpleado().getIdEmpleado());

        tripulacionVueloUpdated.setPuesto(tripulacionVuelo.getPuesto());
        tripulacionVueloUpdated = tripulacionVueloRepository.save(tripulacionVueloUpdated);
        return tripulacionVueloUpdated;
    }

    @Transactional
    public void quitarTripulante(Long idVuelo, Long idEmpleado) {
        logger.info("Quitando tripulante {} del vuelo {}", idEmpleado, idVuelo);
        Empleado empleado = empleadoRepository.findById(idEmpleado).get();
        empleado.setEstadoEmpleado(EmpleadoEstado.DISPONIBLE);
        empleadoRepository.save(empleado);

        tripulacionVueloRepository.deleteTripulacionVueloByVuelo_IdVueloAndEmpleado_IdEmpleado(idVuelo, idEmpleado);
    }


    // Elimino la tripulacion del vuelo
    @Transactional
    public void deleteTripulacionVueloByVueloId(Long idVuelo) {
        DisponibilizarEmpleados(idVuelo);
        tripulacionVueloRepository.deleteAllByVuelo_IdVuelo(idVuelo);
    }

    private void DisponibilizarEmpleados(Long idVuelo) {
        logger.info("Disponibilizando empleados del vuelo con id: {}", idVuelo);
        List<TripulacionVuelo> tripulantes = getTripulantesByVueloId(idVuelo);
        logger.debug("Empleados obtenidos exitosamente: {}", tripulantes);
        
        if (!tripulantes.isEmpty()) {
            for (TripulacionVuelo tripulante : tripulantes) {
                logger.debug("Disponibilizando empleado con id: {}", tripulante.getEmpleado().getIdEmpleado());
                tripulante.getEmpleado().setEstadoEmpleado(EmpleadoEstado.DISPONIBLE);
                empleadoRepository.save(tripulante.getEmpleado());
            }
        }
    }

    // TRIPULANTES PUESTOS
    public List<TripulantePuesto> getAllTripulantePuestos() {
        return tripulantePuestoRepository.findAll();
    }
    
    /**
     * Obtiene una lista de empleados que pueden ser asignados a un vuelo.
     * Incluye empleados DISPONIBLES y los que ya están asignados al vuelo especificado.
     * 
     * @param idVuelo ID del vuelo (opcional). Si se proporciona, incluye a los empleados ya asignados a ese vuelo.
     * @return Lista de empleados en formato DTO
     */
    @Transactional
    public List<TripulanteDTO> getEmpleadosParaTripulacionDeAVuelo(Long idVuelo) {
        logger.info("Si idVuelo no es nulo se buscan los tripulantes asignados.");
        List<TripulanteDTO> tripulantesAsignados = idVuelo != null
            ? tripulacionVueloRepository
                .findByVuelo_IdVuelo(idVuelo)
                .stream()
                .map(this::mapToTripulanteDTO)
                .collect(Collectors.toList())
            : new ArrayList<>();

        logger.info("Se agregan todos los empleados disponibles.");
        tripulantesAsignados.addAll(empleadoRepository
            .findByEstadoEmpleado(EmpleadoEstado.DISPONIBLE)
            .stream()
            .map(TripulanteDTO::new)
            .collect(Collectors.toList()));

        return tripulantesAsignados;
    }

    private TripulanteDTO mapToTripulanteDTO(TripulacionVuelo tripulacion) {
        TripulanteDTO dto = new TripulanteDTO(tripulacion.getEmpleado());
        dto.setPuestoTripulante(tripulacion.getPuesto());
        dto.setIdVueloAsignado(tripulacion.getVuelo().getIdVuelo());
        return dto;
    }
}