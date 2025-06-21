package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.enums.EmpleadoEstado;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.TripulacionVuelo;
import com.airpatagonia.backend.models.TripulantePuesto;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.repositories.EmpleadoRepository;
import com.airpatagonia.backend.services.TripulacionVueloService;
import com.airpatagonia.backend.dtos.TripulanteDTO;
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
    
    @Mock
    private EmpleadoRepository empleadoRepository;

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
    void getEmpleadosParaAsignar_WithVueloId_ShouldReturnListOfTripulanteDTO() throws Exception {
        // Arrange
        when(tripulacionVueloService.getEmpleadosParaTripulacionDeAVuelo(1L)).thenReturn(
            Arrays.asList(new TripulanteDTO(empleado))
        );

        // Act & Assert
        mockMvc.perform(get("/tripulacion-vuelo/")
                .param("idVuelo", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).getEmpleadosParaTripulacionDeAVuelo(1L);
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void getEmpleadosParaAsignar_WithoutVueloId_ShouldReturnListOfTripulanteDTO() throws Exception {
        // Arrange
        when(tripulacionVueloService.getEmpleadosParaTripulacionDeAVuelo(null)).thenReturn(
            Arrays.asList(new TripulanteDTO(empleado))
        );

        // Act & Assert
        mockMvc.perform(get("/tripulacion-vuelo/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).getEmpleadosParaTripulacionDeAVuelo(null);
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void getTripulantesVuelo_ShouldReturnListOfEmpleados() throws Exception {
        // Arrange
        when(tripulacionVueloService.getTripulantesByVueloId(1L)).thenReturn(Arrays.asList(asignacion));

        // Act & Assert
        mockMvc.perform(get("/tripulacion-vuelo/1/tripulantes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idTripulacionVuelo", is(1)))
                .andExpect(jsonPath("$[0].empleado.idEmpleado", is(1)))
                .andExpect(jsonPath("$[0].empleado.nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).getTripulantesByVueloId(1L);
        verifyNoMoreInteractions(tripulacionVueloService);
    }

    @Test
    void asignarTripulante_ShouldReturnCreated() throws Exception {
        // Arrange
        // Crear un nuevo vuelo con ID
        Vuelo vueloRequest = new Vuelo();
        vueloRequest.setIdVuelo(1L);
        
        // Crear un nuevo empleado con ID y estado
        Empleado empleadoRequest = new Empleado();
        empleadoRequest.setIdEmpleado(1L);
        empleadoRequest.setNombre("Carlos");
        empleadoRequest.setApellido("Lopez");
        empleadoRequest.setEstadoEmpleado(EmpleadoEstado.DISPONIBLE);
        
        // Crear un nuevo puesto con ID
        TripulantePuesto puestoRequest = new TripulantePuesto();
        puestoRequest.setIdPuestoTripulante(1L);
        puestoRequest.setPuesto("Piloto");
        
        // Crear la asignación
        TripulacionVuelo asignacionRequest = new TripulacionVuelo();
        asignacionRequest.setVuelo(vueloRequest);
        asignacionRequest.setEmpleado(empleadoRequest);
        asignacionRequest.setPuesto(puestoRequest);
        
        // Configurar el mock del servicio
        when(tripulacionVueloService.asignarTripulanteAVuelo(any(TripulacionVuelo.class))).thenReturn(empleadoRequest);
        
        // Crear manualmente el JSON para evitar problemas con la serialización de los enums
        String requestJson = """
        {
            "vuelo": {
                "idVuelo": 1
            },
            "empleado": {
                "idEmpleado": 1,
                "nombre": "Carlos",
                "apellido": "Lopez",
                "estadoEmpleado": "DISPONIBLE"
            },
            "puesto": {
                "idPuestoTripulante": 1,
                "puesto": "Piloto"
            }
        }
        """;
        
        // Act & Assert
        mockMvc.perform(post("/tripulacion-vuelo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(result -> {
                    System.out.println("Response Status: " + result.getResponse().getStatus());
                    System.out.println("Response Content: " + result.getResponse().getContentAsString());
                })
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idEmpleado", is(1)))
                .andExpect(jsonPath("$.nombre", is("Carlos")));

        verify(tripulacionVueloService, times(1)).asignarTripulanteAVuelo(any(TripulacionVuelo.class));
        verifyNoMoreInteractions(tripulacionVueloService);
    }
    
    @Test
    void asignarTripulante_WithMismatchedVueloId_ShouldReturnBadRequest() throws Exception {
        // Arrange
        String requestJson = """
        {
            "vuelo": {
                "idVuelo": 2
            },
            "empleado": {
                "idEmpleado": 1
            },
            "puesto": {
                "idPuestoTripulante": 1
            }
        }
        """;
        
        // Act & Assert
        mockMvc.perform(post("/tripulacion-vuelo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest());
                
        verifyNoInteractions(tripulacionVueloService);
    }

    @Test
    void updateTripulante_ShouldReturnUpdatedTripulacion() throws Exception {
        // Arrange
        TripulacionVuelo updatedAsignacion = new TripulacionVuelo();
        updatedAsignacion.setIdTripulacionVuelo(1L);
        
        Vuelo vuelo = new Vuelo();
        vuelo.setIdVuelo(1L);
        
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(1L);
        
        TripulantePuesto nuevoPuesto = new TripulantePuesto();
        nuevoPuesto.setIdPuestoTripulante(2L);
        nuevoPuesto.setPuesto("Copiloto");
        
        updatedAsignacion.setVuelo(vuelo);
        updatedAsignacion.setEmpleado(empleado);
        updatedAsignacion.setPuesto(nuevoPuesto);
        
        when(tripulacionVueloService.updateTripulante(any(TripulacionVuelo.class))).thenReturn(updatedAsignacion);
        
        String requestJson = """
        {
            "idTripulacionVuelo": 1,
            "vuelo": {
                "idVuelo": 1
            },
            "empleado": {
                "idEmpleado": 1
            },
            "puesto": {
                "idPuestoTripulante": 2,
                "puesto": "Copiloto"
            }
        }
        """;
        
        // Act & Assert
        mockMvc.perform(put("/tripulacion-vuelo/1/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTripulacionVuelo", is(1)))
                .andExpect(jsonPath("$.puesto.puesto", is("Copiloto")));
                
        verify(tripulacionVueloService, times(1)).updateTripulante(any(TripulacionVuelo.class));
        verifyNoMoreInteractions(tripulacionVueloService);
    }
    
    @Test
    void updateTripulante_WithMismatchedIds_ShouldReturnBadRequest() throws Exception {
        // Arrange
        String requestJson = """
        {
            "vuelo": {
                "idVuelo": 2
            },
            "empleado": {
                "idEmpleado": 2
            },
            "puesto": {
                "idPuestoTripulante": 1,
                "puesto": "Piloto"
            }
        }
        """;
        
        // Act & Assert
        mockMvc.perform(put("/tripulacion-vuelo/1/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest());
                
        verifyNoInteractions(tripulacionVueloService);
    }
    
    @Test
    void quitarTripulante_ShouldReturnNoContent() throws Exception {
        // Arrange
        doNothing().when(tripulacionVueloService).quitarTripulante(1L, 1L);

        // Act & Assert
        mockMvc.perform(delete("/tripulacion-vuelo/1/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(tripulacionVueloService, times(1)).quitarTripulante(1L, 1L);
        verifyNoMoreInteractions(tripulacionVueloService);
    }
    
    @Test
    void getAllTripulantePuestos_ShouldReturnListOfPuestos() throws Exception {
        // Arrange
        when(tripulacionVueloService.getAllTripulantePuestos()).thenReturn(
            Arrays.asList(puesto)
        );

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
