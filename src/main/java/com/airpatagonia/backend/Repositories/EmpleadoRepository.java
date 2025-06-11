package com.airpatagonia.backend.Repositories;

import java.util.List;
import java.util.Optional;

import com.airpatagonia.backend.models.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findAll();

    Optional<Empleado> findById(Long id);
}
