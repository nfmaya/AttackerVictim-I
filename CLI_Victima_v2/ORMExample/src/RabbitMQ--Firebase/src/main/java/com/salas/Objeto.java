package com.salas;

import java.io.Serializable;
//Clase del Objeto que tendra los datos del mensaje a enviar
public  class Objeto implements Serializable
{
    private int objetoid;
    private String nombre;
    private String apellido;
    private String mensaje;
    private String tiempo;

    public int getObjetotId()
    {
        return objetoid;
    }

    public void setObjetoId(int productId)
    {
        this.objetoid = productId;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String name)
    {
        this.nombre = name;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMensaje()
    {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString()
    {
        return "Product [Id= " + objetoid + ", nombre= " + nombre +",apellido= "+apellido+", mensaje= " + mensaje + ",Tiempo= "+tiempo+"]";
    }



}