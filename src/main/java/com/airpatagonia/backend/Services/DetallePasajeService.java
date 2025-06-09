package com.airpatagonia.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.airpatagonia.backend.models.DetallePasaje;
import com.airpatagonia.backend.Repositories.DetallePasajeRepository;

@Service
public class DetallePasajeService {

    @Autowired
    private DetallePasajeRepository detallePasajeRepository;

    public List<DetallePasaje> getAllDetallePasajes() {
        return detallePasajeRepository.findAll();
    }
    
}
