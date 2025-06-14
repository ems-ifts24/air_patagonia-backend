package com.airpatagonia.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.models.Ciudad;
import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.repositories.CiudadRepository;
import com.airpatagonia.backend.repositories.PaisRepository;

@Service
public class UbicacionService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private CiudadRepository ciudadRepository;
    

    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }
}
