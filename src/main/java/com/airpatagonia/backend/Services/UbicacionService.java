package com.airpatagonia.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.models.Ciudad;
import com.airpatagonia.backend.Repositories.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository.PaisRepository paisRepository;

    @Autowired
    private UbicacionRepository.CiudadRepository ciudadRepository;
    

    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }
}
