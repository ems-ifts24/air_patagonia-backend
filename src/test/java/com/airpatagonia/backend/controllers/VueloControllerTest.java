package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.controllers.VueloController;
import com.airpatagonia.backend.enums.VueloEstado;
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
                .andExpect(jsonPath("$[0].estado", is("PROGRAMADO")))
                .andExpect(jsonPath("$[1].idVuelo", is(2)))
                .andExpect(jsonPath("$[1].estado", is("EN_VUELO")));

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
                .andExpect(jsonPath("$.estado", is("PROGRAMADO")));

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
                .andExpect(jsonPath("$[0].estado", is("PROGRAMADO")));

        verify(vueloService, times(1)).getVuelosByEstado(VueloEstado.PROGRAMADO);
        verifyNoMoreInteractions(vueloService);
    }

    @Test
    void getAllVuelosEstados_ShouldReturnListOfEstados() throws Exception {
        // Arrange
        List<String> estados = Arrays.asList("PROGRAMADO", "EN_VUELO", "ATERRIZADO", "CANCELADO");
        when(vueloService.getAllVuelosEstados()).thenReturn(estados);

        // Act & Assert
        mockMvc.perform(get("/vuelos/estados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$", containsInAnyOrder("PROGRAMADO", "EN_VUELO", "ATERRIZADO", "CANCELADO")));

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
}
