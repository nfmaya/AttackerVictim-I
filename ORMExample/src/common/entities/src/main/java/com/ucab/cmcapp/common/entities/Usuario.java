package com.ucab.cmcapp.common.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private long _idUsuario;

    @Column(name = "Username")
    private String _Username;

    @Column(name = "NombreUsuario")
    private String _Nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "user_type_id", nullable = false )
    private UserType _userType;

    public Usuario() {

    }

    public Usuario(Usuario usuario){
        _Username = usuario._Username;
        _Nombre = usuario._Nombre;
        _userType = usuario._userType;
    }

    public Usuario( long id )
    {
        _idUsuario = id;
    }

    public long get_idUsuario() {
        return _idUsuario;
    }

    public void set_idUsuario(long _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public String get_Username() {
        return _Username;
    }

    public void set_Username(String _Username) {
        this._Username = _Username;
    }

    public String get_Nombre() {
        return _Nombre;
    }

    public void set_Nombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public UserType get_userType() {
        return _userType;
    }

    public void set_userType(UserType _userType) {
        this._userType = _userType;
    }
}
