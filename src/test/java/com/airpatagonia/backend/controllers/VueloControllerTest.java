package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.enums.VueloEstado;
import com.airpatagonia.backend.exceptions.ResourceNotFoundException;
import com.airpatagonia.backend.models.DetallePasaje;
import com.airpatagonia.backend.models.PagoDePasaje;
import com.airpatagonia.backend.models.Vuelo;
import com.airpatagonia.backend.services.DetallePasajeService;
import com.airpatagonia.backend.services.PagoDePasajeService;
import com.airpatagonia.backend.services.VueloService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VueloControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VueloService vueloService;

    @Mock
    private PagoDePasajeService pagoDePasajeService;

    @Mock
    private DetallePasajeService detallePasajeService;

    @InjectMocks
    private VueloController vueloController;

    private Vuelo vuelo1;
    private Vuelo vuelo2;
    private List<Vuelo> vuelos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vueloController).build();
        
        // Datos de prueba
        vuelo1 = new Vuelo();
        vuelo1.setIdVuelo(1L);
        vuelo1.setEstado(VueloEstado.PROGRAMADO);
        
        vuelo2 = new Vuelo();
        vuelo2.setIdVuelo(2L);
        vuelo2.setEstado(VueloEstado.EN_VUELO);
        
        vuelos = Arrays.asList(vuelo1, vuelo2);
    }

    @Test
    void getAllVuelos_ShouldReturnListOfVuelos() throws Exception {
        // Arrange
        when(vueloService.getAllVuelos()).thenReturn(vuelos);

        // Act & Assert
        mockMvc.perform(get("/vuelos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idVuelo", is(1)))
                .andExpect(jsonPath("$[0].estado.nombre", is("PROGRAMADO")))
                .andExpect(jsonPath("$[0].estado.descripcion", is("Programado")))
                .andExpect(jsonPath("$[1].idVuelo", is(2)))
                .andExpect(jsonPath("$[1].estado.nombre", is("EN_VUELO")))
                .andExpect(jsonPath("$[1].estado.descripcion", is("En vuelo")));

        verify(vueloService, times(1)).getAllVuelos();
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getVueloById_WhenVueloExists_ShouldReturnVuelo() throws Exception {
        // Arrange
        when(vueloService.getVueloById(1L)).thenReturn(vuelo1);

        // Act & Assert
        mockMvc.perform(get("/vuelos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idVuelo", is(1)))
                .andExpect(jsonPath("$.estado.nombre", is("PROGRAMADO")))
                .andExpect(jsonPath("$.estado.descripcion", is("Programado")));

        verify(vueloService, times(1)).getVueloById(1L);
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getVueloById_WhenVueloNotExists_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(vueloService.getVueloById(999L)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/vuelos/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(vueloService, times(1)).getVueloById(999L);
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getVuelosByEstado_ShouldReturnFilteredVuelos() throws Exception {
        // Arrange
        when(vueloService.getVuelosByEstado(VueloEstado.PROGRAMADO)).thenReturn(Arrays.asList(vuelo1));

        // Act & Assert
        mockMvc.perform(get("/vuelos/estado/PROGRAMADO")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idVuelo", is(1)))
                .andExpect(jsonPath("$[0].estado.nombre", is("PROGRAMADO")))
                .andExpect(jsonPath("$[0].estado.descripcion", is("Programado")));

        verify(vueloService, times(1)).getVuelosByEstado(VueloEstado.PROGRAMADO);
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getAllVuelosEstados_ShouldReturnListOfEstados() throws Exception {
        // Arrange
        List<VueloEstado> estados = Arrays.asList(VueloEstado.values());
        when(vueloService.getAllVuelosEstados()).thenReturn(estados);

        // Act & Assert
        mockMvc.perform(get("/vuelos/estados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(estados.size())))
                .andExpect(jsonPath("$[0].nombre", is(estados.get(0).name())))
                .andExpect(jsonPath("$[0].descripcion", is(estados.get(0).getDescripcion())));

        verify(vueloService, times(1)).getAllVuelosEstados();
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getAllPagosDePasaje_ShouldReturnListOfPagos() throws Exception {
        // Arrange
        PagoDePasaje pago = new PagoDePasaje();
        pago.setIdPago(1L);
        pago.setMonto(new BigDecimal("1000.00"));
        
        when(pagoDePasajeService.getAllPagosDePasaje()).thenReturn(Arrays.asList(pago));

        // Act & Assert
        mockMvc.perform(get("/vuelos/pagos-pasajes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idPago", is(1)))
                .andExpect(jsonPath("$[0].monto", is(1000.00)));

        verify(pagoDePasajeService, times(1)).getAllPagosDePasaje();
        verifyNoMoreInteractions(pagoDePasajeService);
    }

    @Test
    void getAllDetallePasajes_ShouldReturnListOfDetalles() throws Exception {
        // Arrange
        DetallePasaje detalle = new DetallePasaje();
        detalle.setId(1L);
        detalle.setAsiento("A1");
        
        when(detallePasajeService.getAllDetallePasajes()).thenReturn(Arrays.asList(detalle));

        // Act & Assert
        mockMvc.perform(get("/vuelos/detalle-pasajes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].asiento", is("A1")));

        verify(detallePasajeService, times(1)).getAllDetallePasajes();
        verifyNoMoreInteractions(detallePasajeService);
    }
    
    @Test
    void createVuelo_WithValidData_ShouldReturnCreated() throws Exception {
        // Arrange
        Vuelo createdVuelo = new Vuelo();
        createdVuelo.setIdVuelo(1L);
        createdVuelo.setEstado(VueloEstado.PROGRAMADO);
        
        when(vueloService.createVuelo(any())).thenReturn(createdVuelo);
        
        // JSON manual con formato ISO-8601 para las fechas
        String jsonRequest = """
        {
            "idVuelo": 1,
            "estado": "PROGRAMADO",
            "idAvion": 1,
            "idAeropuertoPartida": 1,
            "idAeropuertoArribo": 2,
            "fechaPartida": "2025-06-15T10:00:00",
            "fechaArribo": "2025-06-15T12:00:00"
        }
        """;
        
        // Act & Assert
        mockMvc.perform(post("/vuelos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idVuelo", is(1)))
                .andExpect(jsonPath("$.estado.nombre", is("PROGRAMADO")));
                
        verify(vueloService, times(1)).createVuelo(any());
        verifyNoMoreInteractions(vueloService);
    }
    
    @Test
    void createVuelo_WithInvalidData_ShouldReturnUnprocessableEntity() throws Exception {
        // Arrange
        when(vueloService.createVuelo(any())).thenReturn(null);
        
        // JSON con datos inválidos (faltan campos requeridos)
        String invalidJson = "{}";
        
        // Act & Assert
        mockMvc.perform(post("/vuelos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isUnprocessableEntity());
                
        verify(vueloService, times(1)).createVuelo(any());
        verifyNoMoreInteractions(vueloService);
    }
    
    @Test
    void updateVuelo_WhenVueloExists_ShouldReturnUpdatedVuelo() throws Exception {
        // Arrange
        Vuelo updatedVuelo = new Vuelo();
        updatedVuelo.setIdVuelo(1L);
        updatedVuelo.setEstado(VueloEstado.DEMORADO);
        
        when(vueloService.updateVuelo(any())).thenReturn(updatedVuelo);
        
        String requestBody = """
        {
            "idVuelo": 1,
            "estado": "DEMORADO"
        }
        """;
        
        // Act & Assert
        mockMvc.perform(put("/vuelos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idVuelo", is(1)))
                .andExpect(jsonPath("$.estado.nombre", is("DEMORADO")));
        
        verify(vueloService, times(1)).updateVuelo(any());
        verifyNoMoreInteractions(vueloService);
    }
    
    @Test
    void updateVuelo_WhenVueloNotExists_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(vueloService.updateVuelo(any())).thenThrow(new ResourceNotFoundException("Vuelo no encontrado"));
        
        String requestBody = """
        {
            "idVuelo": 999,
            "estado": "DEMORADO"
        }
        """;
        
        // Act & Assert
        mockMvc.perform(put("/vuelos/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isNotFound());
        
        verify(vueloService, times(1)).updateVuelo(any());
        verifyNoMoreInteractions(vueloService);
    }
    
    @Test
    void updateVuelo_WhenIdMismatch_ShouldReturnBadRequest() throws Exception {
        // Arrange
        String requestBody = """
        {
            "idVuelo": 2,
            "estado": "DEMORADO"
        }
        """;
        
        // Act & Assert
        mockMvc.perform(put("/vuelos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
        
        verifyNoInteractions(vueloService);
    }
    
    @Test
    void deleteVuelo_WhenVueloExists_ShouldReturnNoContent() throws Exception {
        // Arrange
        Vuelo deletedVuelo = new Vuelo();
        deletedVuelo.setIdVuelo(1L);
        deletedVuelo.setEstado(VueloEstado.BAJA_LOGICA);
        
        when(vueloService.deleteVuelo(1L)).thenReturn(deletedVuelo);
        
        // Act & Assert
        mockMvc.perform(delete("/vuelos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        
        verify(vueloService, times(1)).deleteVuelo(1L);
        verifyNoMoreInteractions(vueloService);
    }
    
    @Test
    void deleteVuelo_WhenVueloNotExists_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(vueloService.deleteVuelo(999L)).thenReturn(null);
        
        // Act & Assert
        mockMvc.perform(delete("/vuelos/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        
        verify(vueloService, times(1)).deleteVuelo(999L);
        verifyNoMoreInteractions(vueloService);
    }
}
