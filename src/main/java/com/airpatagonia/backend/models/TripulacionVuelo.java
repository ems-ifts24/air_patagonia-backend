package com.airpatagonia.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "TripulacionVuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripulacionVuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTripulacionVuelo")
    private Long idTripulacionVuelo;

    @ManyToOne
    @JoinColumn(name = "IdVuelo", nullable = false)
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "IdEmpleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "IdPuestoTripulante", nullable = false)
    private TripulantePuesto puesto;
}