package com.airpatagonia.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.enums.EmpleadoEstado;
import com.airpatagonia.backend.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.status(200).body(empleados);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null) {
            return ResponseEntity.status(200).body(empleado);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Empleado>> getEmpleadosByEstado(@PathVariable EmpleadoEstado estado) {
        List<Empleado> empleados = empleadoService.getEmpleadosByEstado(estado);
        if (empleados.isEmpty()) {
            logger.info("No se encontraron empleados con el estado: {}", estado);
            return ResponseEntity.status(404).build();
        }
        logger.info("Se encontraron {} empleados con el estado: {}", empleados.size(), estado);
        return ResponseEntity.status(200).body(empleados);
    }
}
