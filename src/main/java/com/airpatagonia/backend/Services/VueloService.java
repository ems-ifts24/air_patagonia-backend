package com.airpatagonia.backend.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.airpatagonia.backend.Enums.VueloEstado;

@Service
public class VueloService {
    
    public List<String> getAllVuelosEstados() {
        return Arrays.stream(VueloEstado.values())
                .map(VueloEstado::getDescripcion)
                .collect(Collectors.toList());
    }

}
