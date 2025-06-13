package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.Services.AeropuertoService;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AeropuertoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AeropuertoService aeropuertoService;

    @InjectMocks
    private AeropuertoController aeropuertoController;

    private List<Aeropuerto> aeropuertos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(aeropuertoController).build();
        
        // Datos de prueba
        Aeropuerto aeropuerto1 = new Aeropuerto();
        aeropuerto1.setIdAeropuerto(1L);
        aeropuerto1.setNombreAeropuerto("Aeropuerto Internacional Ezeiza");
        aeropuerto1.setCodigoIATA("EZE");
        
        Aeropuerto aeropuerto2 = new Aeropuerto();
        aeropuerto2.setIdAeropuerto(2L);
        aeropuerto2.setNombreAeropuerto("Aeroparque Jorge Newbery");
        aeropuerto2.setCodigoIATA("AEP");
        
        aeropuertos = Arrays.asList(aeropuerto1, aeropuerto2);
    }

    @Test
    void getAllAeropuertos_ShouldReturnListOfAeropuertos() throws Exception {
        // Arrange
        when(aeropuertoService.getAllAeropuertos()).thenReturn(aeropuertos);

        // Act & Assert
        mockMvc.perform(get("/aeropuertos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idAeropuerto", is(1)))
                .andExpect(jsonPath("$[0].nombreAeropuerto", is("Aeropuerto Internacional Ezeiza")))
                .andExpect(jsonPath("$[1].idAeropuerto", is(2)))
                .andExpect(jsonPath("$[1].nombreAeropuerto", is("Aeroparque Jorge Newbery")));

        verify(aeropuertoService, times(1)).getAllAeropuertos();
        verifyNoMoreInteractions(aeropuertoService);
    }
}
