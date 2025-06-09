package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.Services.TripulanteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tripulantes")
public class TripulanteController {

    @Autowired
    private TripulanteService tripulanteService;

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

    @GetMapping("/puestos")
    public List<String> getAllTripulantePuestos() {
        return tripulanteService.getAllTripulantePuestos();
    }
}
