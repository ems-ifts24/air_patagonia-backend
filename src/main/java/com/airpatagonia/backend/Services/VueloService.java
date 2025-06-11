package com.airpatagonia.backend.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.Repositories.VueloRepository;
import com.airpatagonia.backend.Repositories.TripulantePuestoRepository;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.models.TripulantePuesto;

@Service
public class VueloService {
    
    private static final Logger logger = LoggerFactory.getLogger(VueloService.class);

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private TripulantePuestoRepository tripulantePuestoRepository;
    
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

    public Vuelo createVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public Vuelo updateVuelo(Long id, Vuelo vuelo) {
        Vuelo vueloToUpdate = getVueloById(id);
        vueloToUpdate.setFechaPartida(vuelo.getFechaPartida());
        vueloToUpdate.setFechaArribo(vuelo.getFechaArribo());
        vueloToUpdate.setEstado(vuelo.getEstado());
        return vueloRepository.save(vueloToUpdate);
    }

    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }

    public List<String> getAllVuelosEstados() {
        return Arrays.stream(VueloEstado.values())
                .map(VueloEstado::getDescripcion)
                .collect(Collectors.toList());
    }



    // TRIPULANTES

    public List<TripulantePuesto> getAllTripulantePuestos() {
        return tripulantePuestoRepository.findAll();
    }
}
