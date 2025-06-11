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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private VueloEstado estado;

    @Column(name = "fecha_partida")
    private LocalDateTime fechaPartida;

    @Column(name = "fecha_arribo")
    private LocalDateTime fechaArribo;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "origen_id")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Aeropuerto destino;

    @ManyToMany
    @JoinTable(name = "vuelo_tripulante", joinColumns = @JoinColumn(name = "vuelo_id"), inverseJoinColumns = @JoinColumn(name = "tripulante_id"))
    private List<Empleado> tripulantes;

    @ManyToMany
    @JoinTable(name = "vuelo_pasajero", joinColumns = @JoinColumn(name = "vuelo_id"), inverseJoinColumns = @JoinColumn(name = "pasajero_id"))
    private List<Pasajero> pasajeros;
}
