package com.airpatagonia.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private String genero;
    private String nacionalidad;
    private String tipoPasaporte;
    private String numeroPasaporte;
    private String fechaExpiracionPasaporte;
    private String paisOrigen;
    private String paisResidencia;
    private String direccion;
    private String codigoPostal;
    private String ciudad;
    private String provincia;
    private String pais;
    private String coordenadas;
}
