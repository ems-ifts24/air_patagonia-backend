package com.airpatagonia.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.Aeropuerto;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    
    List<Aeropuerto> findAll();
}
