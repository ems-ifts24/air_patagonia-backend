package com.airpatagonia.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.repositories.AeropuertoRepository;

@Service
public class AeropuertoService {
    
    @Autowired
    private AeropuertoRepository aeropuertoRepository;
    
    public List<Aeropuerto> getAllAeropuertos() {
        return aeropuertoRepository.findAll();
    }
}
