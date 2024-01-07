package com.ucab.cmcapp.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TiempoControl")
public class TiempoControl {

    /**
     *
     */



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTiempo")
    private long IdTiempo;


    @Column(name = "TipoTiempoControl")
    private String TipoTiempoControl;


    @Column(name = "TiempoControl")
    private float tiempoControl;



    public TiempoControl() {

    }


    public TiempoControl(float tiempoControl, String TipoTiempoControl) {
        this.tiempoControl = tiempoControl;
        this.TipoTiempoControl = TipoTiempoControl;
    }

    public TiempoControl (long id){
        IdTiempo = id;
    }


    public long getIdTiempo() {
        return IdTiempo;
    }

    public void setIdTiempo(long idTiempo) {
        IdTiempo = idTiempo;
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
