package com.ucab.cmcapp.logic.dtos;


import java.util.List;

public class DistanciaAlejamientoDto extends BaseDto
{
    private float _distanciaMinima;


    private UsuarioDto _victima;

    private UsuarioDto _agresor;




    public DistanciaAlejamientoDto()
    {
    }

    public DistanciaAlejamientoDto( long id )
    {
        super( id );
    }

    public float get_distanciaMinima() {
        return _distanciaMinima;
    }

    public void set_distanciaMinima(float _distanciaMinima) {
        this._distanciaMinima = _distanciaMinima;
    }

    public UsuarioDto get_victima() {
        return _victima;
    }

    public void set_victima(UsuarioDto _victima) {
        this._victima = _victima;
    }

    public UsuarioDto get_agresor() {
        return _agresor;
    }

    public void set_agresor(UsuarioDto _agresor) {
        this._agresor = _agresor;
    }


}
