package com.airpatagonia.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.services.AeropuertoService;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping
    public ResponseEntity<List<Aeropuerto>> getAllAeropuertos() {
        List<Aeropuerto> aeropuertos = aeropuertoService.getAllAeropuertos();
        return ResponseEntity.status(200).body(aeropuertos);
    }
}
