package com.airpatagonia.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.Services.AvionService;

@RestController
@RequestMapping("/aviones")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping
    public List<Avion> getAllAviones() {
        return avionService.getAllAviones();
    }
    
}
