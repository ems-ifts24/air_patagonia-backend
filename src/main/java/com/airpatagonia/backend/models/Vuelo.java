package com.airpatagonia.backend.models;

import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.Pasajero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @Column(name = "IdVuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado")
    private VueloEstado estado;

    @Column(name = "FechaPartida")
    private LocalDateTime fechaPartida;

    @Column(name = "FechaArribo")
    private LocalDateTime fechaArribo;

    @ManyToOne
    @JoinColumn(name = "IdAvion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "IdAeropuertoPartida")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "IdAeropuertoArribo")
    private Aeropuerto destino;

    @ManyToMany
    @JoinTable(name = "TripulacionVuelo", joinColumns = @JoinColumn(name = "IdVuelo"), inverseJoinColumns = @JoinColumn(name = "IdEmpleado"))
    private List<Empleado> tripulantes;

    @ManyToMany
    @JoinTable(name = "Pasajero", joinColumns = @JoinColumn(name = "IdVuelo"), inverseJoinColumns = @JoinColumn(name = "IdCliente"))
    private List<Pasajero> pasajeros;
}
