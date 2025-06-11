package com.airpatagonia.backend.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.Repositories.VueloRepository;
import com.airpatagonia.backend.Repositories.TripulantePuestoRepository;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.models.TripulantePuesto;

@Service
public class VueloService {
    
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
