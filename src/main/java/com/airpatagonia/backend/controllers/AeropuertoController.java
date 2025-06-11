package com.airpatagonia.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.Services.AeropuertoService;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @GetMapping
    public List<Aeropuerto> getAllAeropuertos() {
        return aeropuertoService.getAllAeropuertos();
    }
}
