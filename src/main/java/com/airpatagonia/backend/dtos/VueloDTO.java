package com.airpatagonia.backend.dtos;

import java.time.LocalDateTime;

import com.airpatagonia.backend.enums.VueloEstado;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueloDTO {

    private VueloEstado estado = VueloEstado.PROGRAMADO;
    private LocalDateTime fechaPartida;
    private LocalDateTime fechaArribo;
    private Long idAvion;
    private Long idAeropuertoPartida;
    private Long idAeropuertoArribo;
}
