package com.airpatagonia.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.Services.VueloService;
import com.airpatagonia.backend.models.PagoDePasaje;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.Services.PagoDePasajeService;
import com.airpatagonia.backend.models.DetallePasaje;
import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.Services.DetallePasajeService;
import com.airpatagonia.backend.models.TripulantePuesto;

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

   
    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloService.getAllVuelos();
    }

    @GetMapping("/{id}")
    public Vuelo getVueloById(@PathVariable Long id) {
        return vueloService.getVueloById(id);
    }

    @GetMapping("/estados/{estado}")
    public List<Vuelo> getVuelosByEstado(@PathVariable VueloEstado estado) {
        logger.info("Buscando vuelos por estado: " + estado.name());
        return vueloService.getVuelosByEstado(estado);
    }



    // @GetMapping
    // public List<Tripulante> getAllTripulantes() {
    //     return tripulanteService.getAllTripulantes();
    // }


    // @PostMapping
    // public Tripulante createTripulante(@RequestBody Tripulante tripulante) {
    //     return tripulanteService.createTripulante(tripulante);
    // }

    // @PutMapping("/{id}")
    // public Tripulante updateTripulante(@PathVariable Long id, @RequestBody Tripulante tripulante) {
    //     return tripulanteService.updateTripulante(id, tripulante);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteTripulante(@PathVariable Long id) {
    //     tripulanteService.deleteTripulante(id);
    // }

    @GetMapping("/estados")
    public List<String> getAllVuelosEstados() {
        return vueloService.getAllVuelosEstados();
    }

    @GetMapping("/pagos-pasajes")
    public List<PagoDePasaje> getAllPagosDePasaje() {
        return pagoDePasajeService.getAllPagosDePasaje();
    }

    @GetMapping("/detalle-pasajes")
    public List<DetallePasaje> getAllDetallePasajes() {
        return detallePasajeService.getAllDetallePasajes();
    }

    // TRIPULANTES
    
    @GetMapping("/tripulantes/puestos")
    public List<TripulantePuesto> getAllTripulantePuestos() {
        return vueloService.getAllTripulantePuestos();
    }
}
