package com.ucab.cmcapp.logic.dtos;

import java.util.Date;


public class CoordenadaZonaSeguridadDto extends BaseDto{

    /**
     *
     */

    private float coordenadaX;


    private float coordenadaY;



    private ZonaSeguridadDto zonaSeguridad;





    public CoordenadaZonaSeguridadDto() {

    }

    public CoordenadaZonaSeguridadDto(long id )
    {
        super( id );
    }


    public float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(float coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(float coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public ZonaSeguridadDto getZonaSeguridad() {
        return zonaSeguridad;
    }

    public void setZonaSeguridad(ZonaSeguridadDto zonaSeguridad) {
        this.zonaSeguridad = zonaSeguridad;
    }
}
