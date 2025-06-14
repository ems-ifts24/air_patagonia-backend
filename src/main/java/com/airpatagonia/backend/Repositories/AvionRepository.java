package com.airpatagonia.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

    public List<Avion> findAll();
    
}
