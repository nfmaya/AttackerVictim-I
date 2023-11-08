package com.ucab.cmcapp.common.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Posicion")
public class Posicion {

    /**
     *
     */





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPos")
    private long IdPos;




    @Column(name = "CoordenadaX")
    private float coordenadaX;

    @Column(name = "CoordenadaY")
    private float coordenadaY;

    /*
    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario usuario;

     */

    @Column(name = "FechaHora")
    private Date fechaHora;


    public Posicion() {

    }

    public Posicion(float coordenadaX, float coordenadaY , Date fechaHora) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        this.fechaHora = fechaHora;
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

    /*
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

     */

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }



    // Define relationships if needed
}
