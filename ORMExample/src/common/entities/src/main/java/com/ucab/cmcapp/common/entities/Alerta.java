package com.ucab.cmcapp.common.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Alertas")
public class Alerta {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlerta")
    private long IdAlerta;

    @Column(name = "TipoAlerta")
    private String tipoAlerta;

    @ManyToOne
    @JoinColumn(name = "Victima_id")
    private Usuario victima;

    @Column(name = "FechaHora")
    private LocalDateTime fechaHora;

    public Alerta(){

    }


    //SE USA EL QUE TIENE ID PARA EL UPDATE
    public Alerta(long idAlerta, String tipoAlerta, Usuario victima, LocalDateTime fechaHora) {
        this.IdAlerta = idAlerta;
        this.tipoAlerta = tipoAlerta;
        this.victima = victima;
        this.fechaHora = fechaHora;
    }



    public Alerta(String tipoAlerta, Usuario victima, LocalDateTime fechaHora) {
        this.tipoAlerta = tipoAlerta;
        this.victima = victima;
        this.fechaHora = fechaHora;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public Usuario getVictima() {
        return victima;
    }

    public void setVictima(Usuario victima) {
        this.victima = victima;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Alerta [tipoAlerta=" + tipoAlerta + ", victima=" + victima + ", fechaHora=" + fechaHora + "]";
    }

    // Define relationships if needed
}
