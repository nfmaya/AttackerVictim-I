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
@Table(name = "CoordenadasZonaSeguridad")
public class CoordenadaZonaSeguridad {

    /**
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCoor")
    private long IdCoor;

    /*
    @ManyToOne
    @JoinColumn(name = "IdZona")
    private ZonaSeguridad zonaSeguridad;
    //VER SI ES ManyToMAny
     */

    @Column(name = "CoordenadaX")
    private float coordenadaX;

    @Column(name = "CoordenadaY")
    private float coordenadaY;



    public CoordenadaZonaSeguridad() {

    }

/*
    public CoordenadaZonaSeguridad(ZonaSeguridad zonaSeguridad, float coordenadaX, float coordenadaY) {
        this.zonaSeguridad = zonaSeguridad;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

 */

    public CoordenadaZonaSeguridad(float coordenadaX, float coordenadaY) {

        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }




    public CoordenadaZonaSeguridad (long id){
        IdCoor = id;
    }

    public long getIdCoor() {
        return IdCoor;
    }



    public void setIdCoor(long idCoor) {
        IdCoor = idCoor;
    }

    /*
    public ZonaSeguridad getZonaSeguridad() {
        return zonaSeguridad;
    }

    public void setZonaSeguridad(ZonaSeguridad zonaSeguridad) {
        this.zonaSeguridad = zonaSeguridad;
    }

     */

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


    // Define relationships if needed
}
