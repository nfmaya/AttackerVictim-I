package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic.GetZonaSeguridadUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguridadUsuarioCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadUsuarioCommand.class );
    private ZonaSeguridadUsuario _user;
    long _id;

    public GetZonaSeguridadUsuarioCommand( ZonaSeguridadUsuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguridadUsuarioCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdZonaUsuario();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguridadUsuarioCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetZonaSeguridadUsuarioByIdCommand getZonaSeguridadUsuarioByIdCommand = CommandFactory.createGetZonaSeguridadUsuarioByIdCommand(getHandler(), _id);
            getZonaSeguridadUsuarioByIdCommand.execute();
            _user = getZonaSeguridadUsuarioByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public ZonaSeguridadUsuario getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
