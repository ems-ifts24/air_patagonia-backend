package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.airpatagonia.backend.enums.AvionEstado;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "Avion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAvion")
    private Long idAvion;
    @Column(name = "Fabricante")
    private String fabricante;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "CapacidadTurista")
    private Integer capacidadTurista;
    @Column(name = "CapacidadBusiness")
    private Integer capacidadBusiness;
    @Column(name = "CapacidadPrimera")
    private Integer capacidadPrimeraClase;
    @Column(name = "Autonomia")
    private Double autonomia;
    @Column(name = "Matricula")
    private String matricula;

    // Agrego enumerated type.STRING para que relaciones el nombre del Enum con el varchar guardado en la base de datos
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado")
    private AvionEstado estado;
}
