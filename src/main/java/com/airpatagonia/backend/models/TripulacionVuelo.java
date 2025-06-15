package com.airpatagonia.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
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

    @Positive
    @ManyToOne
    @JoinColumn(name = "IdVuelo", nullable = false)
    @NotNull
    private Vuelo vuelo;

    @Positive
    @ManyToOne
    @JoinColumn(name = "IdEmpleado", nullable = false)
    @NotNull
    private Empleado empleado;

    @Positive
    @ManyToOne
    @JoinColumn(name = "IdPuestoTripulante", nullable = false)
    @NotNull
    private TripulantePuesto puesto;
}