package com.ucab.cmcapp.common.entities;

import javax.persistence.*;


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


    @Column(name = "CoordenadaX")
    private float coordenadaX;

    @Column(name = "CoordenadaY")
    private float coordenadaY;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdZona", nullable = false)
    private ZonaSeguridad zonaSeguridad;


    public CoordenadaZonaSeguridad() {

    }

    public CoordenadaZonaSeguridad(CoordenadaZonaSeguridad coordenadaZonaSeguridad) {
        zonaSeguridad = coordenadaZonaSeguridad.zonaSeguridad;
        coordenadaX = coordenadaZonaSeguridad.coordenadaX;
        coordenadaY = coordenadaZonaSeguridad.coordenadaY;
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


    public ZonaSeguridad getZonaSeguridad() {
        return zonaSeguridad;
    }

    public void setZonaSeguridad(ZonaSeguridad zonaSeguridad) {
        this.zonaSeguridad = zonaSeguridad;
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


    // Define relationships if needed
}
