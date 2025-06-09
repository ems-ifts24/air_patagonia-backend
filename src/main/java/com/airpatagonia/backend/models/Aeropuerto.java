package com.airpatagonia.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto {
    private Long id;
    private String nombre;
    private String codigoIATA;
    private String codigoICAO;
    private String ciudad;
    private String pais;
    private String coordenadas;
}
