package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateDistanciaByIdCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateDistanciaByIdCommand.class );
    private DistanciaAlejamiento _distancia;
    private DistanciaAlejamientoDao _dao;

    public UpdateDistanciaByIdCommand(DistanciaAlejamiento distancia, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateDistanciaByIdCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        setHandler(handler);
        _distancia = distancia;
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateDistanciaByIdCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    public UpdateDistanciaByIdCommand(DistanciaAlejamiento distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateDistanciaByIdCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _distancia = distancia;
        setHandler(new DBHandler());
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateDistanciaByIdCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateDistanciaByIdCommand.execute" );
        //endregion

        _dao.update( _distancia);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateDistanciaByIdCommand.execute" );
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
