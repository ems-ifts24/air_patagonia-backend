package com.airpatagonia.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airpatagonia.backend.models.TripulantePuesto;

import org.springframework.stereotype.Repository;

@Repository
public interface TripulantePuestoRepository extends JpaRepository<TripulantePuesto, Long> {

    List<TripulantePuesto> findAll();
}
