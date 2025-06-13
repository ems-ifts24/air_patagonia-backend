package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.Services.AvionService;
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

class AvionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AvionService avionService;

    @InjectMocks
    private AvionController avionController;

    private List<Avion> aviones;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(avionController).build();
        
        // Datos de prueba
        Avion avion1 = new Avion();
        avion1.setIdAvion(1L);
        avion1.setMatricula("LV-ABC");
        avion1.setModelo("Boeing 737-800");
        
        Avion avion2 = new Avion();
        avion2.setIdAvion(2L);
        avion2.setMatricula("LV-XYZ");
        avion2.setModelo("Airbus A320");
        
        aviones = Arrays.asList(avion1, avion2);
    }

    @Test
    void getAllAviones_ShouldReturnListOfAviones() throws Exception {
        // Arrange
        when(avionService.getAllAviones()).thenReturn(aviones);

        // Act & Assert
        mockMvc.perform(get("/aviones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idAvion", is(1)))
                .andExpect(jsonPath("$[0].matricula", is("LV-ABC")))
                .andExpect(jsonPath("$[1].idAvion", is(2)))
                .andExpect(jsonPath("$[1].matricula", is("LV-XYZ")));

        verify(avionService, times(1)).getAllAviones();
        verifyNoMoreInteractions(avionService);
    }
}
