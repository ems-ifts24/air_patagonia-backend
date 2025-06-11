package com.airpatagonia.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Pais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    
    @Id
    @Column(name = "IdPais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(name = "Nombre")
    private String nombre;
    
}
