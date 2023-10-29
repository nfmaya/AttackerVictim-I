package com.ucab.cmcapp.common.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private long idUsuario;

    @Column(name = "Username")
    private String Username;

    @Column(name = "NombreUsuario")
    private String Nombre;

    @Column(name = "TipoUsuario")
    private String Tipo;

    public Usuario() {

    }




    public Usuario(long idUsuario, String username, String nombre, String tipo) {
        this.idUsuario = idUsuario;
        this.Username = username;
        this.Nombre = nombre;
        this.Tipo = tipo;
    }




    public Usuario(String username, String nombre, String tipo) {
        this.Username = username;
        this.Nombre = nombre;
        this.Tipo = tipo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
