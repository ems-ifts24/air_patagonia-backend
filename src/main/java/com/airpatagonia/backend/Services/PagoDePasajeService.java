package com.airpatagonia.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.airpatagonia.backend.models.PagoDePasaje;
import com.airpatagonia.backend.repositories.PagoDePasajeRepository;

@Service
public class PagoDePasajeService {

    @Autowired
    private PagoDePasajeRepository pagoDePasajeRepository;

    public List<PagoDePasaje> getAllPagosDePasaje() {
        return pagoDePasajeRepository.findAll();
    }
    
}
