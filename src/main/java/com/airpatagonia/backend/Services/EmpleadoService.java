package com.airpatagonia.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.enums.EmpleadoEstado;
import com.airpatagonia.backend.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public List<Empleado> getEmpleadosByEstado(EmpleadoEstado estado) {
        return empleadoRepository.findByEstadoEmpleado(estado);
    }
}
