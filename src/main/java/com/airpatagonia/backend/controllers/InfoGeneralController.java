package com.airpatagonia.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.airpatagonia.backend.Services.UbicacionService;
import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.models.Ciudad;

@RestController
@RequestMapping("/info-general")
public class InfoGeneralController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/status")
    public String getStatus() {
        return "API AirPatagonia Backend OK";
    }

    @GetMapping("/paises")
    public List<Pais> getPaises() {
        return ubicacionService.getPaises();
    }

    @GetMapping("/ciudades")
    public List<Ciudad> getCiudades() {
        return ubicacionService.getCiudades();
    }

}
