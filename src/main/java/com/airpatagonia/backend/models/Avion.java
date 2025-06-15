package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotNull
    @Positive
    private Long idAvion;
    @Column(name = "Fabricante")
    @NotNull
    private String fabricante;
    @Column(name = "Modelo")
    @NotNull
    private String modelo;
    @Column(name = "CapacidadTurista")
    @NotNull
    @Positive
    private Integer capacidadTurista;
    @Column(name = "CapacidadBusiness")
    @NotNull
    @Positive
    private Integer capacidadBusiness;
    @Column(name = "CapacidadPrimera")
    @NotNull
    @Positive
    private Integer capacidadPrimeraClase;
    @Column(name = "Autonomia")
    @NotNull
    @Positive
    private Double autonomia;
    @Column(name = "Matricula")
    @NotNull
    private String matricula;

    // Agrego enumerated type.STRING para que relaciones el nombre del Enum con el varchar guardado en la base de datos
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado")
    private AvionEstado estadoAvion = AvionEstado.DISPONIBLE;
}
