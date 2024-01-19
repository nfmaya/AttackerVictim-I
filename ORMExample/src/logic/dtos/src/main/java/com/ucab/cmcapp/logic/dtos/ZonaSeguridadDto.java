package com.ucab.cmcapp.logic.dtos;

public class ZonaSeguridadDto extends BaseDto{


    private String nombreZona;


    //VER SI HAY RELACION ManyToMany con CoordenadaZonaSeguridad

    public ZonaSeguridadDto() {

    }

    public ZonaSeguridadDto(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public ZonaSeguridadDto( long id )
    {
        super( id );
    }


    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }
}
