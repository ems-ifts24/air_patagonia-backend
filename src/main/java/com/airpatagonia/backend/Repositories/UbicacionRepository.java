package com.airpatagonia.backend.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.models.Ciudad;

@Repository
public interface UbicacionRepository {

    interface PaisRepository extends JpaRepository<Pais, Long> {
    
        public List<Pais> findAll();

        public Optional findById(Long id);

        public List<Pais> findByNombreContainingIgnoreCase(String nombre);
    }
    
    interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    
        public List<Ciudad> findAll();

        public Optional findById(Long id);

        public List<Ciudad> findByNombreContainingIgnoreCase(String nombre);
    }
}
