package com.airpatagonia.backend.controllers;

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

    @GetMapping("/{idVuelo}/tripulantes")
    @Operation(summary = "Obtener todos los tripulantes de un vuelo")
    public ResponseEntity<List<Empleado>> getTripulantesVuelo(@PathVariable Long idVuelo) {
        logger.info("Buscando tripulantes para el vuelo con id: {}", idVuelo);
        List<Empleado> tripulantes = tripulacionVueloService.getTripulantesByVueloId(idVuelo);
        return ResponseEntity.status(200).body(tripulantes);
    }

    @PostMapping
    @Operation(summary = "Asignar un tripulante a un vuelo")
    public ResponseEntity<Empleado> asignarTripulante(@RequestBody TripulacionVuelo asignacion) {
        logger.info("Asignando tripulante al vuelo {}", asignacion.getVuelo().getIdVuelo());
        Empleado empleadoAsignado = tripulacionVueloService.asignarTripulanteAVuelo(asignacion);
        return ResponseEntity.status(201).body(empleadoAsignado);
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
    public ResponseEntity<List<TripulantePuesto>> getAllTripulantePuestos() {
        logger.info("Obteniendo todos los puestos de tripulación");
        List<TripulantePuesto> puestos = tripulacionVueloService.getAllTripulantePuestos();
        return ResponseEntity.status(200).body(puestos);
    }
}