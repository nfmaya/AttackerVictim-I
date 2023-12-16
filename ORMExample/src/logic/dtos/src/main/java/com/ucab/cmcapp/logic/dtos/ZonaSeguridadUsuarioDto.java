package com.ucab.cmcapp.logic.dtos;

public class ZonaSeguridadUsuarioDto extends BaseDto{


    private UsuarioDto usuarioDto;

    private ZonaSeguridadDto zonaSeguridadDto;


    //VER SI HAY RELACION ManyToMany con CoordenadaZonaSeguridadUsuario

    public ZonaSeguridadUsuarioDto() {

    }


    public ZonaSeguridadUsuarioDto(long id )
    {
        super( id );
    }


    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public ZonaSeguridadDto getZonaSeguridadDto() {
        return zonaSeguridadDto;
    }

    public void setZonaSeguridadDto(ZonaSeguridadDto zonaSeguridadDto) {
        this.zonaSeguridadDto = zonaSeguridadDto;
    }
}
