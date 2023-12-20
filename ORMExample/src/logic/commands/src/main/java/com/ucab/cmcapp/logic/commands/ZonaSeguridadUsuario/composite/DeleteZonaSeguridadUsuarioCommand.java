package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic.DeleteZonaSeguridadUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguridadUsuarioCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguridadUsuarioCommand.class );
    private ZonaSeguridadUsuario _user;
    private ZonaSeguridadUsuario _result;
    private DeleteZonaSeguridadUsuarioByIdCommand _addZonaSeguridadUsuarioCommand;

    public DeleteZonaSeguridadUsuarioCommand(ZonaSeguridadUsuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguridadUsuarioCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteZonaSeguridadUsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteZonaSeguridadUsuarioCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addZonaSeguridadUsuarioCommand = CommandFactory.createDeleteZonaSeguridadUsuarioByIdCommand(_user, getHandler());
            _addZonaSeguridadUsuarioCommand.execute();
            _result = _addZonaSeguridadUsuarioCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteZonaSeguridadUsuarioCommand.execute");
        //endregion
    }

    @Override
    public ZonaSeguridadUsuario getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
