package com.ucab.cmcapp.logic.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TiempoControlDto extends BaseDto{


    private String TipoTiempoControl;


    private float tiempoControl;


    public TiempoControlDto() {

    }

    public TiempoControlDto( long id )
    {
        super( id );
    }


    public String getTipoTiempoControl() {
        return TipoTiempoControl;
    }

    public void setTipoTiempoControl(String tipoTiempoControl) {
        TipoTiempoControl = tipoTiempoControl;
    }

    public float getTiempoControl() {
        return tiempoControl;
    }

    public void setTiempoControl(float tiempoControl) {
        this.tiempoControl = tiempoControl;
    }
}
