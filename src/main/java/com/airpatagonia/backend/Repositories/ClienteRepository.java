package com.airpatagonia.backend.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airpatagonia.backend.models.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findAll();
    
    Optional<Cliente> findById(Long id);
    
}
