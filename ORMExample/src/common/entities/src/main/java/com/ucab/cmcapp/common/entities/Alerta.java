package com.ucab.cmcapp.common.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Alertas")
public class Alerta implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlerta")
    private long _IdAlerta;

    @Column(name = "TipoAlerta")
    private String _tipoAlerta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Victima_id")
    private Usuario _victima;

    @Column(name = "FechaHora")
    private Date _fechaHora;

    public Alerta(){

    }

    public Alerta (Alerta alerta){
        _tipoAlerta = alerta._tipoAlerta;
        _victima = alerta._victima;
        _fechaHora = alerta._fechaHora;

    }

    public Alerta (long id){
        _IdAlerta = id;
    }

    public long get_IdAlerta() {
        return _IdAlerta;
    }

    public void set_IdAlerta(long _IdAlerta) {
        this._IdAlerta = _IdAlerta;
    }

    public String get_tipoAlerta() {
        return _tipoAlerta;
    }

    public void set_tipoAlerta(String _tipoAlerta) {
        this._tipoAlerta = _tipoAlerta;
    }

    public Usuario get_victima() {
        return _victima;
    }

    public void set_victima(Usuario _victima) {
        this._victima = _victima;
    }

    public Date get_fechaHora() {
        return _fechaHora;
    }

    public void set_fechaHora(Date _fechaHora) {
        this._fechaHora = _fechaHora;
    }
}
