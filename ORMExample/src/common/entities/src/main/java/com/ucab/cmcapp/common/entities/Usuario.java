package com.ucab.cmcapp.common.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private long _idUsuario;

    @Column(name = "Username")
    private String _Username;

    @Column(name = "NombreUsuario")
    private String _Nombre;

    //AGREGAR ESTOS ATRIBUTOS

    @Column(name = "DocIdentidad")
    private String DocIdentidad;

    @Column(name = "IMEI")
    private String IMEI;

    @Column(name = "Estatus")
    private boolean Estatus;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "user_type_id", nullable = false )
    private UserType _userType;

    /*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn( name = "IdAlerta" )
    private List<Alerta> alertas;
*/
    public Usuario() {

    }



    public Usuario(Usuario usuario){
        _Username = usuario._Username;
        _Nombre = usuario._Nombre;
        _userType = usuario._userType;
        //alertas = usuario.alertas;
        DocIdentidad = usuario.DocIdentidad;
        IMEI = usuario.IMEI;
        Estatus = usuario.Estatus;
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


    public String getDocIdentidad() {
        return DocIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        DocIdentidad = docIdentidad;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public boolean isEstatus() {
        return Estatus;
    }

    public void setEstatus(boolean estatus) {
        Estatus = estatus;
    }



    /*
    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public void addAlertas(Alerta alerta){
        alertas.add(alerta);
    }

 */
}
