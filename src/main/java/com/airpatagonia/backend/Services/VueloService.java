package com.airpatagonia.backend.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.dtos.VueloDTO;
import com.airpatagonia.backend.enums.VueloEstado;
import com.airpatagonia.backend.exceptions.ResourceNotFoundException;
import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.repositories.AeropuertoRepository;
import com.airpatagonia.backend.repositories.AvionRepository;
import com.airpatagonia.backend.repositories.VueloRepository;

@Service
public class VueloService {
    
    private static final Logger logger = LoggerFactory.getLogger(VueloService.class);

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public List<Vuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    public Vuelo getVueloById(Long id) {
        return vueloRepository.findById(id).orElse(null);
    }

    public List<Vuelo> getVuelosByEstado(VueloEstado estado) {
        List<Vuelo> vuelos = vueloRepository.findByEstado(estado);
        logger.info("Se encontraron {} vuelos con estado: {}", vuelos.isEmpty() ? 0 : vuelos.size(), estado);
        return vuelos;
    }

    public List<String> getAllVuelosEstados() {
        return Arrays.stream(VueloEstado.values())
                .map(VueloEstado::getDescripcion)
                .collect(Collectors.toList());
    }

    public Vuelo createVuelo(VueloDTO vueloDTO) {
        Vuelo vuelo = crearVuelo(vueloDTO);
        vueloRepository.save(vuelo);
        
        logger.info("Vuelo creado exitosamente: {}", vuelo);
        return vuelo;
    }

    private Vuelo crearVuelo(VueloDTO vueloDTO) {
        Vuelo vuelo = new Vuelo();
        vuelo.setFechaPartida(vueloDTO.getFechaPartida());
        vuelo.setFechaArribo(vueloDTO.getFechaArribo());
        vuelo.setEstado(vueloDTO.getEstado());

        obtenerAvion(vuelo, vueloDTO);
        obtenerAeropuerto(vuelo, vueloDTO, true);
        obtenerAeropuerto(vuelo, vueloDTO, false);

        return vuelo;
    }

    private void obtenerAvion(Vuelo vuelo, VueloDTO vueloDTO) {
        if (vueloDTO.getIdAvion() == null)
            throw new RuntimeException("Se recibe Id de avion nulo al insertar un vuelo.");

        Avion avion = avionRepository.findById(vueloDTO.getIdAvion()).get();

        if (avion == null)
            throw new ResourceNotFoundException("Avion no encontrado con id: " + vueloDTO.getIdAvion());

        vuelo.setAvion(avion);
    }

    private void obtenerAeropuerto(Vuelo vuelo, VueloDTO vueloDTO, boolean esOrigen) {
        String aeroPoint = esOrigen ? "Origen" : "Destino";
        logger.info("Obteniendo aeropuerto de {}", aeroPoint);

        if (esOrigen && (vueloDTO.getIdAeropuertoPartida() == null))
            throw new RuntimeException("Se recibe Id de aeropuerto de partida nulo al insertar un vuelo.");
        
        if (!esOrigen && (vueloDTO.getIdAeropuertoArribo() == null))
            throw new RuntimeException("Se recibe Id de aeropuerto de arribo nulo al insertar un vuelo.");
        
        Long aeropuertoId = esOrigen ? vueloDTO.getIdAeropuertoPartida() : vueloDTO.getIdAeropuertoArribo();
        
        Aeropuerto aeropuerto = aeropuertoRepository.findById(aeropuertoId).get();

        if (aeropuerto == null)
            throw new ResourceNotFoundException("Aeropuerto no encontrado con id: " + aeropuertoId);
        
        if (esOrigen)
            vuelo.setAeropuertoPartida(aeropuerto);
        else
            vuelo.setAeropuertoArribo(aeropuerto);
    }
}
