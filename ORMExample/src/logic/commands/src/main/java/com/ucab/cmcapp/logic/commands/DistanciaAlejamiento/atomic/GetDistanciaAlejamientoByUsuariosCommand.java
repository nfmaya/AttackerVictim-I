package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDistanciaAlejamientoByUsuariosCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDistanciaAlejamientoByUsuariosCommand.class );
    private DistanciaAlejamiento _distancia;
    private DistanciaAlejamientoDao _dao;

    public GetDistanciaAlejamientoByUsuariosCommand(DistanciaAlejamiento distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDistanciaAlejamientoByUsuariosCommand.ctor: parameter {%s}", distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetDistanciaAlejamientoByUsuariosCommand.ctor: atribute {%s}", _distancia.toString() ) );
        //endregion
    }

    public GetDistanciaAlejamientoByUsuariosCommand(DistanciaAlejamiento distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDistanciaAlejamientoByUsuariosCommand.ctor: parameter {%s}", distancia.toString() ) );
        _distancia = distancia;
        setHandler(handler);
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetDistanciaAlejamientoByUsuariosCommand.ctor: atribute {%s}", _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
        _distancia = _dao.getDistanciaAlejamientoByUsuarios(_distancia.get_victima().get_idUsuario(),_distancia.get_agresor().get_idUsuario());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
    }

    @Override
    public DistanciaAlejamiento getReturnParam()
    {
        return _distancia;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
