package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.DeleteZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguridadCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguridadCommand.class );
    private ZonaSeguridad _user;
    private ZonaSeguridad _result;
    private DeleteZonaSeguridadByIdCommand _addZonaSeguridadCommand;

    public DeleteZonaSeguridadCommand(ZonaSeguridad user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguridadCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteZonaSeguridadCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguridadCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addZonaSeguridadCommand = CommandFactory.createDeleteZonaSeguridadByIdCommand(_user, getHandler());
            _addZonaSeguridadCommand.execute();
            _result = _addZonaSeguridadCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteZonaSeguridadCommand.execute");
        //endregion
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
