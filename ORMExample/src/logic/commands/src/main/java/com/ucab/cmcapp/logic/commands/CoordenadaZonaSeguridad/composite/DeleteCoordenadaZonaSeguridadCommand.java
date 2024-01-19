package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic.DeleteCoordenadaZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCoordenadaZonaSeguridadCommand extends Command<CoordenadaZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteCoordenadaZonaSeguridadCommand.class );
    private CoordenadaZonaSeguridad _user;
    private CoordenadaZonaSeguridad _result;
    private DeleteCoordenadaZonaSeguridadByIdCommand _addCoordenadaZonaSeguridadCommand;

    public DeleteCoordenadaZonaSeguridadCommand(CoordenadaZonaSeguridad user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteCoordenadaZonaSeguridadCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteCoordenadaZonaSeguridadCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteCoordenadaZonaSeguridadCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addCoordenadaZonaSeguridadCommand = CommandFactory.createDeleteCoordenadaZonaSeguridadByIdCommand(_user, getHandler());
            _addCoordenadaZonaSeguridadCommand.execute();
            _result = _addCoordenadaZonaSeguridadCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteCoordenadaZonaSeguridadCommand.execute");
        //endregion
    }

    @Override
    public CoordenadaZonaSeguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
