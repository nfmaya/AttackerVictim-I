package com.ucab.cmcapp.logic.dtos;

public class DistanciaAlejamientoWithSeparacionDto extends DistanciaAlejamientoDto {
    private double separacion;

    public double getSeparacion() {
        return separacion;
    }

    public void setSeparacion(double separacion) {
        this.separacion = separacion;
    }
}