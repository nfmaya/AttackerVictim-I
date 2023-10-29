package com.ucab.cmcapp.logic.dtos;


public class UsuarioDto extends BaseDto
{
    private long _idUsuario;
    private String _Username;
    private String _Nombre;
    private UserTypeDto _userType;


    public UsuarioDto()
    {
    }

    public UsuarioDto( long id )
    {
        super( id );
    }

    public long get_idUsuario() {
        return _idUsuario;
    }

    public void set_idUsuario(long _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public String get_Username() {
        return _Username;
    }

    public void set_Username(String _Username) {
        this._Username = _Username;
    }

    public String get_Nombre() {
        return _Nombre;
    }

    public void set_Nombre(String _Nombre) {
        this._Nombre = _Nombre;
    }


    public UserTypeDto getUsuarioTypeDto()
    {
        return _userType;
    }

    public void setUsuarioTypeDto( UserTypeDto userType )
    {
        _userType = userType;
    }

}
