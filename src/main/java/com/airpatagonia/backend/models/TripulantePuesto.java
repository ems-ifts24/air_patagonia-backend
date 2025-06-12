package com.airpatagonia.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "PuestoTripulante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripulantePuesto {

    @Id
    @Column(name = "IdPuestoTripulante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuestoTripulante;

    @Column(name = "Puesto")
    private String puesto;

    @Column(name = "Descripcion")
    private String descripcion;
}
