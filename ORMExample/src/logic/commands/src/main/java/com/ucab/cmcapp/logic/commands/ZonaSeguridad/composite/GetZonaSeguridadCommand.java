package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.GetZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadCommand.class );
    private ZonaSeguridad _user;
    long _id;

    public GetZonaSeguridadCommand( ZonaSeguridad user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguridadCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdZona();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguridadCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetZonaSeguridadByIdCommand getZonaSeguridadByIdCommand = CommandFactory.createGetZonaSeguridadByIdCommand(getHandler(), _id);
            getZonaSeguridadByIdCommand.execute();
            _user = getZonaSeguridadByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
