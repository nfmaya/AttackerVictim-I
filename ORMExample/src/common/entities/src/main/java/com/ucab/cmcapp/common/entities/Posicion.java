package com.ucab.cmcapp.common.entities;

import javafx.geometry.Pos;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Posicion")
public class Posicion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPos")
    private long IdPos;

    @Column(name = "CoordenadaX")
    private float coordenadaX;

    @Column(name = "CoordenadaY")
    private float coordenadaY;

    @Column(name = "FechaHora")
    private Date fechaHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Usuario_id", nullable = false)
    private Usuario usuario;


    public Posicion() {

    }

    public Posicion(Posicion posicion) {
        coordenadaX = posicion.coordenadaX;
        coordenadaY = posicion.coordenadaY;
        usuario = posicion.usuario;
        fechaHora = posicion.fechaHora;
    }

    public Posicion (long id){
        IdPos = id;
    }


    public long getIdPos() {
        return IdPos;
    }

    public void setIdPos(long idPos) {
        IdPos = idPos;
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
