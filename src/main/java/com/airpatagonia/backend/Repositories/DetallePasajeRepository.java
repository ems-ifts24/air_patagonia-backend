package com.airpatagonia.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.DetallePasaje;

@Repository
public interface DetallePasajeRepository extends JpaRepository<DetallePasaje, Long> {

    public List<DetallePasaje> findAll();
}
