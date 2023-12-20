package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddZonaSeguridadUsuarioCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( AddZonaSeguridadUsuarioCommand.class );
    private ZonaSeguridadUsuario _ZonaSeguridadUsuario;
    private ZonaSeguridadUsuarioDao _dao;

    public AddZonaSeguridadUsuarioCommand( ZonaSeguridadUsuario ZonaSeguridadUsuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZonaSeguridadUsuarioCommand.ctor: parameter {%s}",
                ZonaSeguridadUsuario.toString() ) );
        setHandler(handler);
        _ZonaSeguridadUsuario = ZonaSeguridadUsuario;
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZonaSeguridadUsuarioCommand.ctor: attribute {%s}",
                _ZonaSeguridadUsuario.toString() ) );
        //endregion
    }

    public AddZonaSeguridadUsuarioCommand( ZonaSeguridadUsuario ZonaSeguridadUsuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddZonaSeguridadUsuarioCommand.ctor: parameter {%s}",
                ZonaSeguridadUsuario.toString() ) );
        _ZonaSeguridadUsuario = ZonaSeguridadUsuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddZonaSeguridadUsuarioCommand.ctor: attribute {%s}",
                _ZonaSeguridadUsuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZonaSeguridadUsuarioCommand.execute" );
        //endregion

        _ZonaSeguridadUsuario = _dao.insert( _ZonaSeguridadUsuario);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddZonaSeguridadUsuarioCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridadUsuario getReturnParam()
    {
        return _ZonaSeguridadUsuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
