package com.airpatagonia.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.models.Ciudad;
import com.airpatagonia.backend.services.UbicacionService;

@RestController
@RequestMapping("/info-general")
public class InfoGeneralController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.status(200).body("API AirPatagonia Backend OK");
    }

    @GetMapping("/paises")
    public ResponseEntity<List<Pais>> getPaises() {
        List<Pais> paises = ubicacionService.getPaises();
        return ResponseEntity.status(200).body(paises);
    }

    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudad>> getCiudades() {
        List<Ciudad> ciudades = ubicacionService.getCiudades();
        return ResponseEntity.status(200).body(ciudades);
    }

}
