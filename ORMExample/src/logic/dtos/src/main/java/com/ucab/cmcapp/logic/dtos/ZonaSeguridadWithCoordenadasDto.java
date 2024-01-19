package com.ucab.cmcapp.logic.dtos;

import java.util.List;

public class ZonaSeguridadWithCoordenadasDto {
    private ZonaSeguridadDto zonaSeguridad;
    private List<CoordenadaZonaSeguridadDto> coordenadas;

    // getters and setters...

    public ZonaSeguridadDto getZonaSeguridad() {
        return zonaSeguridad;
    }

    public void setZonaSeguridad(ZonaSeguridadDto zonaSeguridad) {
        this.zonaSeguridad = zonaSeguridad;
    }

    public List<CoordenadaZonaSeguridadDto> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<CoordenadaZonaSeguridadDto> coordenadas) {
        this.coordenadas = coordenadas;
    }
}