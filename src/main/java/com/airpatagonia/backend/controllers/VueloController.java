package com.airpatagonia.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.Services.VueloService;
import com.airpatagonia.backend.models.PagoDePasaje;
import com.airpatagonia.backend.models.Vuelo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.airpatagonia.backend.Services.PagoDePasajeService;
import com.airpatagonia.backend.models.DetallePasaje;
import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.Services.DetallePasajeService;

@RestController 
@RequestMapping("/vuelos")
@Tag(name = "Vuelos", description = "Gestión de vuelos")
public class VueloController {

    private static final Logger logger = LoggerFactory.getLogger(VueloController.class);

    @Autowired
    private VueloService vueloService;

    @Autowired
    private PagoDePasajeService pagoDePasajeService;

    @Autowired
    private DetallePasajeService detallePasajeService;

   
    // GET Vuelos
    @GetMapping
    @Operation(summary = "Obtener todos los vuelos")
    public ResponseEntity<List<Vuelo>> getAllVuelos() {
        logger.info("Buscando todos los vuelos");
        return ResponseEntity.ok(vueloService.getAllVuelos());
    }

    @GetMapping("/{idVuelo}")
    @Operation(summary = "Obtener un vuelo por su ID")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable Long idVuelo) {
        logger.info("Buscando vuelo con id: {}", idVuelo);
        return ResponseEntity.ok(vueloService.getVueloById(idVuelo));
    }

    @GetMapping("/{estado}")
    @Operation(summary = "Obtener vuelos por estado")
    public ResponseEntity<List<Vuelo>> getVuelosByEstado(@PathVariable VueloEstado estado) {
        logger.info("Buscando vuelos por estado: " + estado.name());
        return ResponseEntity.ok(vueloService.getVuelosByEstado(estado));
    }



    // -----------------------------
    // AUXILIARES
    // -----------------------------

    // Estados de los vuelos
    @GetMapping("/estados")
    @Operation(summary = "Obtener todos los estados de los vuelos")
    public ResponseEntity<List<String>> getAllVuelosEstados() {
        return ResponseEntity.ok(vueloService.getAllVuelosEstados());
    }

    // TEST :: Pagos de pasajes
    @GetMapping("/pagos-pasajes")
    @Operation(summary = "Obtener todos los pagos de pasajes")
    public ResponseEntity<List<PagoDePasaje>> getAllPagosDePasaje() {
        return ResponseEntity.ok(pagoDePasajeService.getAllPagosDePasaje());
    }

    // TEST :: Detalle de pasajes
    @GetMapping("/detalle-pasajes")
    @Operation(summary = "Obtener todos los detalles de pasajes")
    public ResponseEntity<List<DetallePasaje>> getAllDetallePasajes() {
        return ResponseEntity.ok(detallePasajeService.getAllDetallePasajes());
    }
}
