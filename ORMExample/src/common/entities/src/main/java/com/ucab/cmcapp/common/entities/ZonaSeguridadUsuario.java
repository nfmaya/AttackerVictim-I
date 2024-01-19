package com.ucab.cmcapp.common.entities;// In ZonaSeguridadUsuario.java

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import javax.persistence.*;

@Entity
@Table(name = "ZonaSeguridadUsuario")
public class ZonaSeguridadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdZonaUsuario")
    private long IdZonaUsuario;

    @ManyToOne
    @JoinColumn(name = "IdZona", nullable = false)
    private ZonaSeguridad zonaSeguridad;

    @ManyToOne
    @JoinColumn(name = "IdUsuario", nullable = false)
    private Usuario usuario;

    public ZonaSeguridadUsuario() {

    }

    public ZonaSeguridadUsuario(ZonaSeguridadUsuario zonaSeguridadUsuario) {
        zonaSeguridad = zonaSeguridadUsuario.zonaSeguridad;
        usuario = zonaSeguridadUsuario.usuario;
    }


    public ZonaSeguridadUsuario (long id){
        IdZonaUsuario = id;
    }
    // getters and setters...


    public long getIdZonaUsuario() {
        return IdZonaUsuario;
    }

    public void setIdZonaUsuario(long idZonaUsuario) {
        IdZonaUsuario = idZonaUsuario;
    }

    public ZonaSeguridad getZonaSeguridad() {
        return zonaSeguridad;
    }

    public void setZonaSeguridad(ZonaSeguridad zonaSeguridad) {
        this.zonaSeguridad = zonaSeguridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}