package com.ucab.cmcapp.persistence;

import com.ucab.cmcapp.persistence.dao.*;

public class DaoFactory
{
    private DaoFactory() {}

    public static UserDao createUserDao( DBHandler handler )
    {
        return new UserDao( handler );
    }

    public static UsuarioDao createUsuarioDao( DBHandler handler )
    {
        return new UsuarioDao( handler );
    }

    public static AlertaDao createAlertaDao( DBHandler handler )
    {
        return new AlertaDao( handler );
    }

    public static DistanciaAlejamientoDao createDistanciaAlejamientoDao( DBHandler handler )
    {
        return new DistanciaAlejamientoDao( handler );
    }

    public static PosicionDao createPosicionDao( DBHandler handler )
    {
        return new PosicionDao( handler );
    }

    public static PuntoControlDao createPuntoControlDao( DBHandler handler )
    {
        return new PuntoControlDao( handler );
    }

    public static CoordenadaZonaSeguridadDao createCoordenadaZonaSeguridadDao( DBHandler handler )
    {
        return new CoordenadaZonaSeguridadDao( handler );
    }


    public static ZonaSeguridadDao createZonaSeguridadDao( DBHandler handler )
    {
        return new ZonaSeguridadDao( handler );
    }


    public static TiempoControlDao createTiempoControlDao( DBHandler handler )
    {
        return new TiempoControlDao( handler );
    }


}
