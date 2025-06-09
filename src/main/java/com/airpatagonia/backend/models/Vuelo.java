package com.airpatagonia.backend.models;

import com.airpatagonia.backend.Enums.VueloEstado;
import com.airpatagonia.backend.models.Aeropuerto;
import com.airpatagonia.backend.models.Avion;
import com.airpatagonia.backend.models.Empleado;
import com.airpatagonia.backend.models.Pasajero;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private VueloEstado estado;

    private LocalDateTime fechaPartida;

    private LocalDateTime fechaArribo;

    // @ManyToOne
    // @JoinColumn(name = "avion_id")
    private Avion avion;

    // @ManyToOne
    // @JoinColumn(name = "origen_id")
    private Aeropuerto origen;

    // @ManyToOne
    // @JoinColumn(name = "destino_id")
    private Aeropuerto destino;

    // @ManyToMany
    // @JoinTable(name = "vuelo_tripulante", joinColumns = @JoinColumn(name = "vuelo_id"), inverseJoinColumns = @JoinColumn(name = "tripulante_id"))
    private List<Empleado> tripulantes;

    // @ManyToMany
    // @JoinTable(name = "vuelo_pasajero", joinColumns = @JoinColumn(name = "vuelo_id"), inverseJoinColumns = @JoinColumn(name = "pasajero_id"))
    private List<Pasajero> pasajeros;
}
