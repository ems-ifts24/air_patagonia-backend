package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.Services.TripulacionVueloService;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.models.Empleado;
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
    public ResponseEntity<List<Empleado>> getTripulantesVuelo(@PathVariable Long idVuelo) {
        logger.info("Buscando tripulantes para el vuelo con id: {}", idVuelo);
        return ResponseEntity.status(200).body(tripulacionVueloService.getTripulantesByVueloId(idVuelo));
    }

    @PostMapping
    public ResponseEntity<Empleado> asignarTripulante(@RequestBody TripulacionVuelo asignacion) {
        logger.info("Asignando tripulante {} al vuelo {}", asignacion.getEmpleado().getNombre(), asignacion.getVuelo().getIdVuelo());
        return ResponseEntity.status(201).body(tripulacionVueloService.asignarTripulanteAVuelo(asignacion));
    }

    @DeleteMapping("/{idAsignacion}")
    public ResponseEntity<String> eliminarAsignacion(@PathVariable Long idAsignacion) {
        logger.info("Eliminando asignacion con id: {}", idAsignacion);
        tripulacionVueloService.eliminarAsignacion(idAsignacion);
        return ResponseEntity.status(204).body("Asignacion eliminada exitosamente");
    }



    // TRIPULANTES PUESTOS
    @GetMapping("/puestos")
    public ResponseEntity<List<TripulantePuesto>> getAllTripulantePuestos() {
        logger.info("Buscando todos los puestos");
        return ResponseEntity.ok(tripulacionVueloService.getAllTripulantePuestos());
    }

}