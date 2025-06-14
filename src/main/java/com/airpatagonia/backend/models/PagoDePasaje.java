package com.airpatagonia.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.airpatagonia.backend.enums.PagoTipo;

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
    private LocalDateTime fechaOperacion;

    @Column(name = "Monto")
    private BigDecimal monto;

    // Efectivo
    @Column(name = "SucursalCobro")
    private String sucursalCobro;
    
    @Column(name = "PuestoCobro")
    private String puestoCobro;
    
    // Tarjeta
    @Column(name = "NumeroTarjeta")
    private String numeroTarjeta;

    @Column(name = "TitularTarjeta")
    private String titularTarjeta;

    @Column(name = "EntidadEmisoraTarjeta")
    private String entidadEmisoraTarjeta;

    // Transferencia
    @Column(name = "BancoOrigen")
    private String bancoOrigen;

    @Column(name = "CBUOrigen")
    private String cbuOrigen;

    @Column(name = "NumeroOperacion")
    private String numeroOperacion;
}
