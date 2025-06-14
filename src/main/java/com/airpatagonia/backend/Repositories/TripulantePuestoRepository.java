package com.airpatagonia.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.TripulantePuesto;

@Repository
public interface TripulantePuestoRepository extends JpaRepository<TripulantePuesto, Long> {

    List<TripulantePuesto> findAll();
}
