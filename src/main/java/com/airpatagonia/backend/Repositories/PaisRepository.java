package com.airpatagonia.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    
    public List<Pais> findAll();

    public Optional<Pais> findById(Long id);

    public List<Pais> findByNombreContainingIgnoreCase(String nombre);
}
