package com.ucab.cmcapp.common;

import com.ucab.cmcapp.common.entities.*;

public class EntityFactory

{
    /**
     * Method that returns an instance of User class
     */
    public static User createUser()
    {
        return new User();
    }

    /**
     * Method that returns an instance of User class
     */
    public static User createUser(long id)
    {
        return new User(id);
    }

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
}
