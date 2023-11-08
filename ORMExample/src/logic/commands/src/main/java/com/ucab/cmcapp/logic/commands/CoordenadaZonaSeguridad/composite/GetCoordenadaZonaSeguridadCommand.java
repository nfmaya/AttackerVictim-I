package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic.GetCoordenadaZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordenadaZonaSeguridadCommand extends Command<CoordenadaZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetCoordenadaZonaSeguridadCommand.class );
    private CoordenadaZonaSeguridad _user;
    long _id;

    public GetCoordenadaZonaSeguridadCommand( CoordenadaZonaSeguridad user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetCoordenadaZonaSeguridadCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdCoor();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetCoordenadaZonaSeguridadCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetCoordenadaZonaSeguridadByIdCommand getCoordenadaZonaSeguridadByIdCommand = CommandFactory.createGetCoordenadaZonaSeguridadByIdCommand(getHandler(), _id);
            getCoordenadaZonaSeguridadByIdCommand.execute();
            _user = getCoordenadaZonaSeguridadByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public CoordenadaZonaSeguridad getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
