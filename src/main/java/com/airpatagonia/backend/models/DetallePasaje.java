package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import com.airpatagonia.backend.Enums.PagoEstado;
import com.airpatagonia.backend.Enums.PasajeroCategoria;
import com.airpatagonia.backend.Enums.PasajeEstado;

import java.math.BigDecimal;

@Entity
@Table(name = "DetallePasaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDetallePasaje")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoPasaje")
    private PasajeEstado estadoPasaje;

    @Enumerated(EnumType.STRING)
    @Column(name = "Categoria")
    private PasajeroCategoria categoria;

    @Column(name = "Asiento")
    private String asiento;

    @Column(name = "FechaOperacion")
    private LocalDateTime fechaOperacion;

    @Column(name = "Precio")
    private BigDecimal precio;
    
    // ManyToOne :: Varios DetallePasaje pueden tener el mismo PagoDePasaje
    @ManyToOne
    @JoinColumn(name = "IdPago", referencedColumnName = "IdPago")
    private PagoDePasaje medioDePago;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoPago")
    private PagoEstado estadoPago;
}
