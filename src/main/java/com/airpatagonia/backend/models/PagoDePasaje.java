package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDePasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPago")
    private Long idPago;

    @Column(name = "FechaOperacion")
    private LocalDateTime fechaOperacion = LocalDateTime.now();

    @Column(name = "Monto")
    @NotNull
    @Positive
    private BigDecimal monto;

    // Efectivo
    @Column(name = "SucursalCobro")
    private String sucursalCobro;
    
    @Column(name = "PuestoCobro")
    private String puestoCobro;
    
    // Tarjeta
    @Column(name = "NumeroTarjeta")
    @Pattern(regexp = "\\d{13,19}", message = "El número debe tener entre 13 y 19 dígitos")
    private String numeroTarjeta;

    @Column(name = "TitularTarjeta")
    private String titularTarjeta;

    @Column(name = "EntidadEmisoraTarjeta")
    private String entidadEmisoraTarjeta;

    // Transferencia
    @Column(name = "BancoOrigen")
    private String bancoOrigen;

    @Column(name = "CBUOrigen")
    @Pattern(regexp = "\\d{22}", message = "El CBU debe tener exactamente 22 dígitos") 
    private String cbuOrigen;

    @Column(name = "NumeroOperacion")
    private String numeroOperacion;
}
