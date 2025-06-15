package com.airpatagonia.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.enums.EmpleadoEstado;
import com.airpatagonia.backend.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findAll();

    Optional<Empleado> findById(Long id);

    List<Empleado> findByEstadoEmpleado(EmpleadoEstado estado);
}
