package com.ucab.cmcapp.logic.dtos;


import java.util.Date;
import java.util.List;

public class AlertaDto extends BaseDto
{
    private String _tipoAlerta;
    private Date _fechaHora;
    private UsuarioDto _usuario;


    public AlertaDto()
    {
    }

    public AlertaDto( long id )
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

    public UsuarioDto get_usuario() {
        return _usuario;
    }

    public void set_usuario(UsuarioDto _usuario) {
        this._usuario = _usuario;
    }
}
