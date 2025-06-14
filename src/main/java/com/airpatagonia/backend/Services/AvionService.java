package com.airpatagonia.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.repositories.AvionRepository;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public List<Avion> getAllAviones() {
        return avionRepository.findAll();
    }
}
