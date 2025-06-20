package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.services.EmpleadoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import com.airpatagonia.backend.enums.EmpleadoEstado;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmpleadoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmpleadoService empleadoService;

    @InjectMocks
    private EmpleadoController empleadoController;

    private List<Empleado> empleados;
    private Empleado empleadoExistente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empleadoController).build();
        
        // Datos de prueba
        empleadoExistente = new Empleado();
        empleadoExistente.setIdEmpleado(1L);
        empleadoExistente.setNombre("Carlos");
        empleadoExistente.setApellido("Lopez");
        empleadoExistente.setLegajo("EMP001");
        
        Empleado empleado2 = new Empleado();
        empleado2.setIdEmpleado(2L);
        empleado2.setNombre("Ana");
        empleado2.setApellido("Martinez");
        empleado2.setLegajo("EMP002");
        
        empleados = Arrays.asList(empleadoExistente, empleado2);
    }

    @Test
    void getAllEmpleados_ShouldReturnListOfEmpleados() throws Exception {
        // Arrange
        when(empleadoService.getAllEmpleados()).thenReturn(empleados);

        // Act & Assert
        mockMvc.perform(get("/empleados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Carlos")))
                .andExpect(jsonPath("$[1].idEmpleado", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Ana")));

        verify(empleadoService, times(1)).getAllEmpleados();
        verifyNoMoreInteractions(empleadoService);
    }

    @Test
    void getEmpleadoById_WhenEmpleadoExists_ShouldReturnEmpleado() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadoById(1L)).thenReturn(empleadoExistente);

        // Act & Assert
        mockMvc.perform(get("/empleados/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmpleado", is(1)))
                .andExpect(jsonPath("$.nombre", is("Carlos")))
                .andExpect(jsonPath("$.apellido", is("Lopez")));

        verify(empleadoService, times(1)).getEmpleadoById(1L);
        verifyNoMoreInteractions(empleadoService);
    }

    @Test
    void getEmpleadoById_WhenEmpleadoNotExists_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadoById(999L)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/empleados/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(empleadoService, times(1)).getEmpleadoById(999L);
        verifyNoMoreInteractions(empleadoService);
    }

    @Test
    void getEmpleadosByEstado_WhenEmpleadosExist_ShouldReturnEmpleados() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadosByEstado(any(EmpleadoEstado.class))).thenReturn(empleados);

        // Act & Assert
        mockMvc.perform(get("/empleados/estado/DISPONIBLE")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Carlos")))
                .andExpect(jsonPath("$[1].idEmpleado", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Ana")));

        verify(empleadoService, times(1)).getEmpleadosByEstado(EmpleadoEstado.DISPONIBLE);
        verifyNoMoreInteractions(empleadoService);
    }

    @Test
    void getEmpleadosByEstado_WhenNoEmpleadosFound_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(empleadoService.getEmpleadosByEstado(any(EmpleadoEstado.class))).thenReturn(List.of());

        // Act & Assert
        mockMvc.perform(get("/empleados/estado/INACTIVO")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(empleadoService, times(1)).getEmpleadosByEstado(EmpleadoEstado.INACTIVO);
        verifyNoMoreInteractions(empleadoService);
    }
}
