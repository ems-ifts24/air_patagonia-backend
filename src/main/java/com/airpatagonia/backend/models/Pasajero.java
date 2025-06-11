package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Table(name = "Pasajero")
@Data
abstract class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPasajero")
    protected Long idPasajero;

    @ManyToOne
    @JoinColumn(name = "DetallePasaje")
    protected DetallePasaje detallePasaje;


    public Pasajero getTipoPasajero() {
        if (this instanceof PasajeroCliente) {
            return (PasajeroCliente) this;
        }
        if (this instanceof PasajeroEmpleado) {
            return (PasajeroEmpleado) this;
        }
        return null;
    }

}
