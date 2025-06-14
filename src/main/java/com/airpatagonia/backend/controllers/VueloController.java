package com.airpatagonia.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.models.DetallePasaje;
import com.airpatagonia.backend.models.PagoDePasaje;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.services.DetallePasajeService;
import com.airpatagonia.backend.services.PagoDePasajeService;
import com.airpatagonia.backend.services.VueloService;
import com.airpatagonia.backend.dtos.VueloDTO;
import com.airpatagonia.backend.enums.VueloEstado;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
@RequestMapping("/vuelos")
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
        return ResponseEntity.status(200).body(vueloService.getAllVuelos());
    }

    @GetMapping("/{idVuelo}")
    @Operation(summary = "Obtener un vuelo por su ID")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable Long idVuelo) {
        logger.info("Buscando vuelo con id: {}", idVuelo);
        Vuelo vuelo = vueloService.getVueloById(idVuelo);
        if (vuelo == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(vuelo);
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener vuelos por estado")
    public ResponseEntity<List<Vuelo>> getVuelosByEstado(@PathVariable VueloEstado estado) {
        logger.info("Buscando vuelos por estado: " + estado.name());
        List<Vuelo> vuelos = vueloService.getVuelosByEstado(estado);
        if (vuelos.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(vuelos);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo vuelo")
    public ResponseEntity<Vuelo> createVuelo(@RequestBody VueloDTO vueloDTO) {
        logger.info("Creando vuelo: {}", vueloDTO);
        Vuelo vueloCreated = vueloService.createVuelo(vueloDTO);
        if (vueloCreated == null) {
            logger.info("Vuelo no creado");
            return ResponseEntity.status(422).build();
        }
        logger.info("Vuelo creado exitosamente: {}", vueloCreated);
        return ResponseEntity.status(201).body(vueloCreated);
    }

    @PutMapping("/{idVuelo}")
    @Operation(summary = "Actualizar un vuelo por su ID")
    public ResponseEntity<Vuelo> updateVuelo(@PathVariable Long idVuelo, @RequestBody VueloDTO vueloDTO) {
        logger.info("Actualizando vuelo con id: {}", idVuelo);
        Vuelo vueloUpdated = vueloService.updateVuelo(idVuelo, vueloDTO);
        if (vueloUpdated == null) {
            logger.info("Vuelo no encontrado con id: {}", idVuelo);
            return ResponseEntity.status(404).build();
        }
        logger.info("Vuelo actualizado exitosamente: {}", vueloUpdated);
        return ResponseEntity.status(200).body(vueloUpdated);
    }

    @DeleteMapping("/{idVuelo}")
    @Operation(summary = "Eliminar un vuelo por su ID. Liberando a sus tripulantes y colocando a los pasajeros en estado de 'ABIERTO'")
    public ResponseEntity<Vuelo> deleteVuelo(@PathVariable Long idVuelo) {
        logger.info("Eliminando vuelo con id: {}", idVuelo);
        Vuelo vueloDeleted = vueloService.deleteVuelo(idVuelo);
        if (vueloDeleted == null) {
            logger.info("Vuelo no encontrado con id: {}", idVuelo);
            return ResponseEntity.status(404).build();
        }
        logger.info("Vuelo eliminado exitosamente: {}", vueloDeleted);
        return ResponseEntity.status(204).build();
    }



    // -----------------------------
    // AUXILIARES
    // -----------------------------

    // Estados de los vuelos
    @GetMapping("/estados")
    @Operation(summary = "Obtener todos los estados de los vuelos")
    public ResponseEntity<List<String>> getAllVuelosEstados() {
        logger.info("Buscando todos los estados de los vuelos");
        return ResponseEntity.status(200).body(vueloService.getAllVuelosEstados());
    }

    // TEST :: Pagos de pasajes
    @GetMapping("/pagos-pasajes")
    @Operation(summary = "Obtener todos los pagos de pasajes")
    public ResponseEntity<List<PagoDePasaje>> getAllPagosDePasaje() {
        logger.info("Buscando todos los pagos de pasajes");
        return ResponseEntity.status(200).body(pagoDePasajeService.getAllPagosDePasaje());
    }

    // TEST :: Detalle de pasajes
    @GetMapping("/detalle-pasajes")
    @Operation(summary = "Obtener todos los detalles de pasajes")
    public ResponseEntity<List<DetallePasaje>> getAllDetallePasajes() {
        logger.info("Buscando todos los detalles de pasajes");
        return ResponseEntity.status(200).body(detallePasajeService.getAllDetallePasajes());
    }
}
