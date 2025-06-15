package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import com.airpatagonia.backend.enums.PagoEstado;
import com.airpatagonia.backend.enums.PasajeEstado;
import com.airpatagonia.backend.enums.PasajeroCategoria;

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
    private PasajeEstado estadoPasaje = PasajeEstado.VIGENTE;

    @Enumerated(EnumType.STRING)
    @Column(name = "Categoria")
    private PasajeroCategoria categoria = PasajeroCategoria.TURISTA;

    @Column(name = "Asiento")
    @NotNull
    @Positive
    private String asiento;

    @Column(name = "FechaOperacion")
    private LocalDateTime fechaOperacion = LocalDateTime.now();

    @Column(name = "Precio")
    @NotNull
    @Positive
    private BigDecimal precio;
    
    // ManyToOne :: Varios DetallePasaje pueden tener el mismo PagoDePasaje
    @ManyToOne
    @JoinColumn(name = "IdPago", referencedColumnName = "IdPago")
    private PagoDePasaje medioDePago;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoPago")
    private PagoEstado estadoPago = PagoEstado.PENDIENTE;
}
