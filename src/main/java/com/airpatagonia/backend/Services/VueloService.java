package com.airpatagonia.backend.services;

import java.util.Arrays;
import java.util.List;

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

import jakarta.transaction.Transactional;

@Service
public class VueloService {
    
    private static final Logger logger = LoggerFactory.getLogger(VueloService.class);

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @Autowired
    private TripulacionVueloService tripulacionVueloService;


    public List<Vuelo> getAllVuelos() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        vuelos.removeIf(vuelo -> vuelo.getEstado().equals(VueloEstado.BAJA_LOGICA));
        return vuelos;
    }

    public Vuelo getVueloById(Long id) {
        Vuelo vuelo = vueloRepository.findById(id).orElse(null);
        if (vuelo == null)
            throw new ResourceNotFoundException("Vuelo no encontrado con id: " + id);
        return vuelo;
    }

    public List<Vuelo> getVuelosByEstado(VueloEstado estado) {
        List<Vuelo> vuelos = vueloRepository.findByEstado(estado);
        logger.info("Se encontraron {} vuelos con estado: {}", vuelos.isEmpty() ? 0 : vuelos.size(), estado);
        return vuelos;
    }

    public List<VueloEstado> getAllVuelosEstados() {
        return Arrays.asList(VueloEstado.values());
    }

    // Crear vuelo
    public Vuelo createVuelo(VueloDTO vueloDTO) {
        Vuelo vuelo = completarVuelo(new Vuelo(), vueloDTO);
        return vueloRepository.save(vuelo);
    }

    // Actualizar vuelo
    public Vuelo updateVuelo(Long idVuelo, VueloDTO vueloDTO) {
        Vuelo vuelo = getVueloById(idVuelo);
        if (vuelo == null)
            throw new ResourceNotFoundException("Vuelo no encontrado con id: " + idVuelo);
        
        vuelo = completarVuelo(vuelo, vueloDTO);

        return vueloRepository.save(vuelo);
    }

    @Transactional
    public Vuelo deleteVuelo(Long idVuelo) {
        Vuelo vuelo = getVueloById(idVuelo);
        if (vuelo == null)
            throw new ResourceNotFoundException("Vuelo no encontrado con id: " + idVuelo);

        // Baja logica
        vuelo.setEstado(VueloEstado.BAJA_LOGICA);
        Vuelo vueloEliminado = vueloRepository.save(vuelo);

        // Elimino la tripulacion del vuelo 
        tripulacionVueloService.deleteTripulacionVueloByVueloId(idVuelo);

        // Elimino los pasajeros del vuelo
        // TODO: Cambiar el estado de los pasajeros a 'ABIERTO'

        return vueloEliminado;
    }



    // ----------------
    // Metodos privados
    // ----------------
    private Vuelo completarVuelo(Vuelo vuelo, VueloDTO vueloDTO) {
        logger.info("Creando vuelo con datos del dto: {}", vueloDTO);
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
        
        logger.info("Obteniendo avion con id: {}", vueloDTO.getIdAvion());
        Avion avion = avionRepository.findById(vueloDTO.getIdAvion()).get();

        if (avion == null)
            throw new ResourceNotFoundException("Avion no encontrado con id: " + vueloDTO.getIdAvion());

        logger.info("Avion obtenido exitosamente: {}", avion);
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
        
        logger.info("Aeropuerto {} obtenido exitosamente: {}", aeroPoint, aeropuerto);
        if (esOrigen)
            vuelo.setAeropuertoPartida(aeropuerto);
        else
            vuelo.setAeropuertoArribo(aeropuerto);
    }

}
