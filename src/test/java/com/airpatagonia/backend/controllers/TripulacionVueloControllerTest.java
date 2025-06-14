package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.controllers.TripulacionVueloController;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.services.TripulacionVueloService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TripulacionVueloControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private TripulacionVueloService tripulacionVueloService;

    @InjectMocks
    private TripulacionVueloController tripulacionVueloController;

    private Empleado empleado;
    private Vuelo vuelo;
    private TripulantePuesto puesto;
    private TripulacionVuelo asignacion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tripulacionVueloController).build();
        objectMapper = new ObjectMapper();
        
        // Datos de prueba
        empleado = new Empleado();
        empleado.setIdEmpleado(1L);
        empleado.setNombre("Carlos");
        empleado.setApellido("Lopez");
        
        vuelo = new Vuelo();
        vuelo.setIdVuelo(1L);
        
        puesto = new TripulantePuesto();
        puesto.setIdPuestoTripulante(1L);
        puesto.setPuesto("Comandante");
        
        asignacion = new TripulacionVuelo();
        asignacion.setIdTripulacionVuelo(1L);
        asignacion.setEmpleado(empleado);
        asignacion.setVuelo(vuelo);
        asignacion.setPuesto(puesto);
    }

    @Test
    void getTripulantesVuelo_ShouldReturnListOfEmpleados() throws Exception {
        // Arrange
        when(tripulacionVueloService.getTripulantesByVueloId(1L)).thenReturn(Arrays.asList(empleado));

        // Act & Assert
        mockMvc.perform(get("/tripulacion-vuelo/1/tripulantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).getTripulantesByVueloId(1L);
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void asignarTripulante_ShouldReturnCreated() throws Exception {
        // Arrange
        when(tripulacionVueloService.asignarTripulanteAVuelo(any(TripulacionVuelo.class))).thenReturn(empleado);
        
        // Act & Assert
        mockMvc.perform(post("/tripulacion-vuelo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(asignacion)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idEmpleado", is(1)))
                .andExpect(jsonPath("$.nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).asignarTripulanteAVuelo(any(TripulacionVuelo.class));
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void eliminarAsignacion_ShouldReturnNoContent() throws Exception {
        // Arrange
        doNothing().when(tripulacionVueloService).eliminarAsignacion(1L);

        // Act & Assert
        mockMvc.perform(delete("/tripulacion-vuelo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(tripulacionVueloService, times(1)).eliminarAsignacion(1L);
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void getAllTripulantePuestos_ShouldReturnListOfPuestos() throws Exception {
        // Arrange
        when(tripulacionVueloService.getAllTripulantePuestos()).thenReturn(Arrays.asList(puesto));

        // Act & Assert
        mockMvc.perform(get("/tripulacion-vuelo/puestos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idPuestoTripulante", is(1)))
                .andExpect(jsonPath("$[0].puesto", is("Comandante")));

        verify(tripulacionVueloService, times(1)).getAllTripulantePuestos();
        verifyNoMoreInteractions(tripulacionVueloService);
    }
}
