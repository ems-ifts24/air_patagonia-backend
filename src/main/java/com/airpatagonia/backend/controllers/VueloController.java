package com.airpatagonia.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.Services.VueloService;

@RestController 
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    // @GetMapping
    // public List<Vuelo> getAllVuelos() {
    //     VueloEstado estado = VueloEstado.PROGRAMADO.getNombre();
    //     return vueloService.getAllVuelos();
    // }

        // @GetMapping
    // public List<Tripulante> getAllTripulantes() {
    //     return tripulanteService.getAllTripulantes();
    // }

    // @GetMapping("/{id}")
    // public Tripulante getTripulanteById(@PathVariable Long id) {
    //     return tripulanteService.getTripulanteById(id);
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
}
