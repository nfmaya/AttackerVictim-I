package com.ucab.cmcapp.logic.dtos;


public class UsuarioLDAPDto extends BaseDto
{
    private String _Username;
    private String _Nombre;

    private String _Password;

    //private List<AlertaDto> alertas;


    public UsuarioLDAPDto()
    {
    }

    public UsuarioLDAPDto(long id )
    {
        super( id );
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


    public String get_password() {
        return _Password;
    }

    public void set_password(String _Password) {
        this._Password = _Password;
    }

    /*
    public List<AlertaDto> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaDto> alertas) {
        this.alertas = alertas;
    }

 */
}
