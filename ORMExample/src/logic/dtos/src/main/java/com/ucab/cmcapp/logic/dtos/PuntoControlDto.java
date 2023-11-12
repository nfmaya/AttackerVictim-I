package com.ucab.cmcapp.logic.dtos;

import java.util.Date;


public class PuntoControlDto extends BaseDto{

    /**
     *
     */

    private float coordenadaX;


    private float coordenadaY;

    private Date fechaHora;

    private UsuarioDto usuario;



    public PuntoControlDto() {

    }

    public PuntoControlDto(long id )
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


    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }



    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
