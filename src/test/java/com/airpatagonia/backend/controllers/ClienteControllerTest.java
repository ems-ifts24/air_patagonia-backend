package com.airpatagonia.backend.controllers;

import com.airpatagonia.backend.models.Cliente;
import com.airpatagonia.backend.services.ClienteService;

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

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private List<Cliente> clientes;
    private Cliente clienteExistente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
        
        // Datos de prueba
        clienteExistente = new Cliente();
        clienteExistente.setIdCliente(1L);
        clienteExistente.setNombre("Juan");
        clienteExistente.setApellido("Perez");
        clienteExistente.setEmail("juan.perez@example.com");
        
        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(2L);
        cliente2.setNombre("Maria");
        cliente2.setApellido("Gomez");
        cliente2.setEmail("maria.gomez@example.com");
        
        clientes = Arrays.asList(clienteExistente, cliente2);
    }

    @Test
    void getAllClientes_ShouldReturnListOfClientes() throws Exception {
        // Arrange
        when(clienteService.getAllClientes()).thenReturn(clientes);

        // Act & Assert
        mockMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCliente", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")))
                .andExpect(jsonPath("$[1].idCliente", is(2)))
                .andExpect(jsonPath("$[1].nombre", is("Maria")));

        verify(clienteService, times(1)).getAllClientes();
        verifyNoMoreInteractions(clienteService);
    }

    @Test
    void getClienteById_WhenClienteExists_ShouldReturnCliente() throws Exception {
        // Arrange
        when(clienteService.getClienteById(1L)).thenReturn(clienteExistente);

        // Act & Assert
        mockMvc.perform(get("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCliente", is(1)))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Perez")));

        verify(clienteService, times(1)).getClienteById(1L);
        verifyNoMoreInteractions(clienteService);
    }

    @Test
    void getClienteById_WhenClienteNotExists_ShouldReturnNotFound() throws Exception {
        // Arrange
        when(clienteService.getClienteById(999L)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/clientes/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(clienteService, times(1)).getClienteById(999L);
        verifyNoMoreInteractions(clienteService);
    }
}
