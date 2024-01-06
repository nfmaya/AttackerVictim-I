package com.ucab.cmcapp.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ZonaSeguridad")
public class ZonaSeguridad {

    /**
     *
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdZona")
    private long IdZona;

    @Column(name = "NombreZona")
    private String nombreZona;

    //VER SI HAY RELACION ManyToMany con CoordenadaZonaSeguridad

    public ZonaSeguridad() {

    }

    public ZonaSeguridad(String nombreZona) {
        this.nombreZona = nombreZona;
    }


    public ZonaSeguridad (long id){
        IdZona = id;
    }


    public long getIdZona() {
        return IdZona;
    }

    public void setIdZona(long idZona) {
        IdZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }
    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }



}
