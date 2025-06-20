package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.dtos.TripulanteDTO;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.services.TripulacionVueloService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/tripulacion-vuelo")
public class TripulacionVueloController {

    private static final Logger logger = LoggerFactory.getLogger(TripulacionVueloController.class);

    @Autowired
    private TripulacionVueloService tripulacionVueloService;

    @GetMapping("/")
    @Operation(summary = "Obtener lista de empleados asignados y disponibles para asignar a un vuelo")
    public ResponseEntity<List<TripulanteDTO>> getEmpleadosParaAsignar(
            @RequestParam(required = false) Long idVuelo) {
        logger.info("Obteniendo tripulantes para un vuelo.");
        List<TripulanteDTO> empleados = tripulacionVueloService.getEmpleadosParaTripulacionDeAVuelo(idVuelo);
        return ResponseEntity.status(200).body(empleados);
    }

    @GetMapping("/{idVuelo}/tripulantes")
    @Operation(summary = "Obtener todos los tripulantes de un vuelo")
    public ResponseEntity<List<TripulacionVuelo>> getTripulantesVuelo(@PathVariable Long idVuelo) {
        logger.info("Buscando tripulantes para el vuelo con id: {}", idVuelo);
        List<TripulacionVuelo> tripulantes = tripulacionVueloService.getTripulantesByVueloId(idVuelo);
        return ResponseEntity.status(200).body(tripulantes);
    }

    @PostMapping
    @Operation(summary = "Asignar un tripulante a un vuelo")
    public ResponseEntity<Empleado> asignarTripulante(@RequestBody TripulacionVuelo asignacion) {
        logger.info("Asignando tripulante al vuelo {}", asignacion.getVuelo().getIdVuelo());
        Empleado tripulanteAsignado = tripulacionVueloService.asignarTripulanteAVuelo(asignacion);
        return ResponseEntity.status(201).body(tripulanteAsignado);
    }

    @DeleteMapping("/{idVuelo}/{idEmpleado}")
    @Operation(summary = "Quitar un tripulante de un vuelo")
    public ResponseEntity<String> quitarTripulante(@PathVariable Long idVuelo, @PathVariable Long idEmpleado) {
        logger.info("Quitando tripulante {} del vuelo {}", idEmpleado, idVuelo);
        tripulacionVueloService.quitarTripulante(idVuelo, idEmpleado);
        return ResponseEntity.status(204).body("Tripulante quitado exitosamente");
    }

    // TRIPULANTES PUESTOS
    @GetMapping("/puestos")
    @Operation(summary = "Obtener todos los puestos de tripulación disponibles")
    public ResponseEntity<List<TripulantePuesto>> getAllTripulantePuestos() {
        logger.info("Obteniendo todos los puestos de tripulación");
        List<TripulantePuesto> puestos = tripulacionVueloService.getAllTripulantePuestos();
        return ResponseEntity.status(200).body(puestos);
    }
}