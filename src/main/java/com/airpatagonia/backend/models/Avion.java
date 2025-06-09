package com.airpatagonia.backend.models;

import com.airpatagonia.backend.Enums.AvionEstado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fabricante;
    private String modelo;
    private Integer capacidadTurista;
    private Integer capacidadBusiness;
    private Integer capacidadPrimeraClase;
    private Double autonomia;
    private String matricula;
    private AvionEstado estado;
}
