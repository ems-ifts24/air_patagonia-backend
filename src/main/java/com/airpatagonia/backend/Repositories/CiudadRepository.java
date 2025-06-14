package com.airpatagonia.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    public List<Ciudad> findAll();

    public Optional<Ciudad> findById(Long id);

    public List<Ciudad> findByNombreContainingIgnoreCase(String nombre);

}
