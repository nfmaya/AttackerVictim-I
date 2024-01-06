package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddDistanciaAlejamientoCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( AddDistanciaAlejamientoCommand.class );
    private DistanciaAlejamiento _distancia;
    private DistanciaAlejamientoDao _dao;

    public AddDistanciaAlejamientoCommand( DistanciaAlejamiento distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddDistanciaAlejamientoCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        setHandler(handler);
        _distancia = distancia;
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddDistanciaAlejamientoCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    public AddDistanciaAlejamientoCommand( DistanciaAlejamiento distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddDistanciaAlejamientoCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddDistanciaAlejamientoCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddDistanciaAlejamientoCommand.execute" );
        //endregion

        _distancia = _dao.insert( _distancia);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddDistanciaAlejamientoCommand.execute" );
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
