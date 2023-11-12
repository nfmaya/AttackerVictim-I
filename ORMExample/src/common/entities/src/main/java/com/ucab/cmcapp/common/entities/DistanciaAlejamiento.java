package com.ucab.cmcapp.common.entities;

import javax.persistence.*;

@Entity
@Table(name = "DistanciaAlejamiento")
public class DistanciaAlejamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlej")
    private long _IdAlej;


    @Column(name = "DistanciaMinima")
    private float _distanciaMinima;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Victima_id", nullable = false)
    private Usuario _victima;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Agresor_id", nullable = false)
    private Usuario _agresor;



    public DistanciaAlejamiento() {

    }

    public DistanciaAlejamiento(DistanciaAlejamiento distanciaAlejamiento){
        _distanciaMinima = distanciaAlejamiento._distanciaMinima;
        _victima = distanciaAlejamiento._victima;
        _agresor = distanciaAlejamiento._agresor;
    }

    public DistanciaAlejamiento(long id){
        _IdAlej = id;
    }

    public long get_IdAlej() {
        return _IdAlej;
    }

    public void set_IdAlej(long _IdAlej) {
        this._IdAlej = _IdAlej;
    }

    public float get_distanciaMinima() {
        return _distanciaMinima;
    }

    public void set_distanciaMinima(float _distanciaMinima) {
        this._distanciaMinima = _distanciaMinima;
    }


    public Usuario get_victima() {
        return _victima;
    }

    public void set_victima(Usuario _victima) {
        this._victima = _victima;
    }

    public Usuario get_agresor() {
        return _agresor;
    }

    public void set_agresor(Usuario _agresor) {
        this._agresor = _agresor;
    }


}
