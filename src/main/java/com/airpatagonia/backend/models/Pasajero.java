package com.airpatagonia.backend.models;

import lombok.Data;

@Data
abstract class Pasajero {
    protected DetallePasaje detallePasaje;
}
