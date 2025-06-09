package com.airpatagonia.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.airpatagonia.backend.Enums.AerpuertoEstado;

@Entity
@Table(name = "Aeropuerto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAeropuerto")
    private Long idAeropuerto;
    @Column(name = "CodigoIATA")
    private String codigoIATA;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "NombreAeropuerto")
    private String nombreAeropuerto;
    @Column(name = "NombreCorto")
    private String nombreCorto;
    @Column(name = "Pais")
    private String pais;

    // Agrego enumerated type.STRING para que relaciones el nombre del Enum con el varchar guardado en la base de datos
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado")
    private AerpuertoEstado estado;

}    
