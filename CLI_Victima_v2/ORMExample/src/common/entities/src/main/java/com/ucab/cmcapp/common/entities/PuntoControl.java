package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PuntoControl")
public class PuntoControl {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPunt")
    private long IdPunt;


    @Column(name = "CoordenadaX")
    private float coordenadaX;

    @Column(name = "CoordenadaY")
    private float coordenadaY;


    @Column(name = "FechaHora")
    private Date fechaHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Usuario_id", nullable = false)
    private Usuario usuario;



    public PuntoControl() {

    }

    public PuntoControl(PuntoControl puntoControl) {
        coordenadaX = puntoControl.coordenadaX;
        coordenadaY = puntoControl.coordenadaY;
        fechaHora = puntoControl.fechaHora;
        usuario = puntoControl.usuario;
    }

    public PuntoControl(long id){
        IdPunt = id;
    }


    public long getIdPos() {
        return IdPunt;
    }

    public void setIdPos(long idPos) {
        IdPunt = idPos;
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


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }



}
