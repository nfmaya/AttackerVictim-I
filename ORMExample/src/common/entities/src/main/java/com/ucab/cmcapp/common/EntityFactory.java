package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    /**
     * Method that returns an instance of User class
     */


    public static Usuario createUsuario()
    {
        return new Usuario();
    }

    /**
     * Method that returns an instance of User class
     */
    public static Usuario createUsuario(long id)
    {
        return new Usuario(id);
    }

    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType()
    {
        return new UserType();
    }

    /**
     * Method that returns an instance of UserType class
     */
    public static UserType createUserType(long id)
    {
        return new UserType(id);
    }


    public static Alerta createAlerta()
    {
        return new Alerta();
    }


    public static Alerta createAlerta(long id)
    {
        return new Alerta(id);
    }


    public static DistanciaAlejamiento createDistanciaAlejamiento()
    {
        return new DistanciaAlejamiento();
    }


    public static DistanciaAlejamiento createDistanciaAlejamiento(long id)
    {
        return new DistanciaAlejamiento(id);
    }

    public static Posicion createPosicion()
    {
        return new Posicion();
    }

    public static Posicion createPosicion(long id)
    {
        return new Posicion(id);
    }

    public static PuntoControl createPuntoControl()
    {
        return new PuntoControl();
    }

    public static PuntoControl createPuntoControl(long id)
    {
        return new PuntoControl(id);
    }

    public static CoordenadaZonaSeguridad createCoordenadaZonaSeguridad()
    {
        return new CoordenadaZonaSeguridad();
    }

    public static CoordenadaZonaSeguridad createCoordenadaZonaSeguridad(long id)
    {
        return new CoordenadaZonaSeguridad(id);
    }

    public static ZonaSeguridad createZonaSeguridad()
    {
        return new ZonaSeguridad();
    }

    public static ZonaSeguridad createZonaSeguridad(long id)
    {
        return new ZonaSeguridad(id);
    }


    public static TiempoControl  createTiempoControl ()
    {
        return new TiempoControl ();
    }

    public static TiempoControl  createTiempoControl (long id)
    {
        return new TiempoControl (id);
    }
}
