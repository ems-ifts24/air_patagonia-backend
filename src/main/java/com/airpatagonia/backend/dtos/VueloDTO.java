package com.airpatagonia.backend.dtos;

import java.time.LocalDateTime;

import com.airpatagonia.backend.enums.VueloEstado;
import com.airpatagonia.backend.models.Vuelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloDTO {

    private Long idVuelo;
    private String aliasVuelo;
    private VueloEstado estado = VueloEstado.PROGRAMADO;
    private LocalDateTime fechaPartida;
    private LocalDateTime fechaArribo;
    private Long idAvion;
    private Long idAeropuertoPartida;
    private Long idAeropuertoArribo;

    public VueloDTO(Vuelo vuelo) {
        this.idVuelo = vuelo.getIdVuelo();
        this.aliasVuelo = vuelo.getAliasVuelo();
        this.estado = vuelo.getEstado();
        this.fechaPartida = vuelo.getFechaPartida();
        this.fechaArribo = vuelo.getFechaArribo();
        this.idAvion = vuelo.getAvion().getIdAvion();
        this.idAeropuertoPartida = vuelo.getAeropuertoPartida().getIdAeropuerto();
        this.idAeropuertoArribo = vuelo.getAeropuertoArribo().getIdAeropuerto();
    }
}
