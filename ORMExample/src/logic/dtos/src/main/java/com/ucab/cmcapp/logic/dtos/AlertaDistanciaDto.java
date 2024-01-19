package com.ucab.cmcapp.logic.dtos;


import java.util.Date;
import java.util.List;

public class AlertaDistanciaDto extends BaseDto
{
    private String _tipoAlerta;
    private Date _fechaHora;

    private UsuarioDto usuario;

    private DistanciaAlejamientoDto distanciaAlejamiento;

    public AlertaDistanciaDto()
    {
    }



    public AlertaDistanciaDto(long id )
    {
        super( id );
    }

    public String get_tipoAlerta() {
        return _tipoAlerta;
    }

    public void set_tipoAlerta(String _tipoAlerta) {
        this._tipoAlerta = _tipoAlerta;
    }

    public Date get_fechaHora() {
        return _fechaHora;
    }

    public void set_fechaHora(Date _fechaHora) {
        this._fechaHora = _fechaHora;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public DistanciaAlejamientoDto getDistanciaAlejamiento() {
        return distanciaAlejamiento;
    }

    public void setDistanciaAlejamiento(DistanciaAlejamientoDto distanciaAlejamiento) {
        this.distanciaAlejamiento = distanciaAlejamiento;
    }
}
