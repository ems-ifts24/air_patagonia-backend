package com.airpatagonia.backend.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airpatagonia.backend.Enums.TripulantePuesto;

@Service
public class TripulanteService {
    
    // public List<Tripulante> getAllTripulantes() {
    //     return null;
    // }

    // public Tripulante getTripulanteById(Long id) {
    //     return null;
    // }

    // public Tripulante createTripulante(Tripulante tripulante) {
    //     return null;
    // }

    // public Tripulante updateTripulante(Long id, Tripulante tripulante) {
    //     return null;
    // }

    // public void deleteTripulante(Long id) {
    // }

    public List<String> getAllTripulantePuestos() {
        return Arrays.stream(TripulantePuesto.values())
                .map(TripulantePuesto::getDescripcion)
                .collect(Collectors.toList());
    }
}
