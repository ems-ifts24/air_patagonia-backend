package com.airpatagonia.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.TripulacionVuelo;

import java.util.List;

@Repository
public interface TripulacionVueloRepository extends JpaRepository<TripulacionVuelo, Long> {

    List<TripulacionVuelo> findByVuelo_IdVuelo(Long idVuelo);

    List<TripulacionVuelo> findByEmpleado_IdEmpleado(Long idEmpleado);

    boolean existsByVuelo_IdVueloAndEmpleado_IdEmpleado(Long idVuelo, Long idEmpleado);
}