package com.ucab.cmcapp.common.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PuntoControl")
public class PuntoControl {

    /**
     *
     */





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPunt")
    private long IdPunt;




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


    public PuntoControl() {

    }

    public PuntoControl(float coordenadaX, float coordenadaY , Date fechaHora) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        this.fechaHora = fechaHora;
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
