package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.models.Ciudad;
import com.airpatagonia.backend.models.Pais;
import com.airpatagonia.backend.Services.UbicacionService;
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

class InfoGeneralControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UbicacionService ubicacionService;

    @InjectMocks
    private InfoGeneralController infoGeneralController;

    private List<Pais> paises;
    private List<Ciudad> ciudades;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(infoGeneralController).build();
        
        // Datos de prueba para países
        Pais pais1 = new Pais();
        pais1.setIdPais(1L);
        pais1.setNombre("Argentina");
        
        Pais pais2 = new Pais();
        pais2.setIdPais(2L);
        pais2.setNombre("Brasil");
        
        paises = Arrays.asList(pais1, pais2);
        
        // Datos de prueba para ciudades
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setIdCiudad(1L);
        ciudad1.setNombre("Buenos Aires");
        
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setIdCiudad(2L);
        ciudad2.setNombre("Córdoba");
        
        ciudades = Arrays.asList(ciudad1, ciudad2);
    }

    @Test
    void getStatus_ShouldReturnApiStatus() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/info-general/status")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("API AirPatagonia Backend OK"));
    }

    @Test
    void getPaises_ShouldReturnListOfPaises() throws Exception {
        // Arrange
        when(ubicacionService.getPaises()).thenReturn(paises);

        // Act & Assert
        mockMvc.perform(get("/info-general/paises")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idPais", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Argentina")))
                .andExpect(jsonPath("$[1].idPais", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Brasil")));

        verify(ubicacionService, times(1)).getPaises();
        verifyNoMoreInteractions(ubicacionService);
    }

    @Test
    void getCiudades_ShouldReturnListOfCiudades() throws Exception {
        // Arrange
        when(ubicacionService.getCiudades()).thenReturn(ciudades);

        // Act & Assert
        mockMvc.perform(get("/info-general/ciudades")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCiudad", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Buenos Aires")))
                .andExpect(jsonPath("$[1].idCiudad", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Córdoba")));

        verify(ubicacionService, times(1)).getCiudades();
        verifyNoMoreInteractions(ubicacionService);
    }
}
