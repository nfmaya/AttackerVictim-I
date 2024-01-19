package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic.AddZonaSeguridadUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateZonaSeguridadUsuarioCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateZonaSeguridadUsuarioCommand.class );
    private ZonaSeguridadUsuario _user;
    private ZonaSeguridadUsuario _result;
    private AddZonaSeguridadUsuarioCommand _addZonaSeguridadUsuarioCommand;

    public CreateZonaSeguridadUsuarioCommand(ZonaSeguridadUsuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguridadUsuarioCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateZonaSeguridadUsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateZonaSeguridadUsuarioCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addZonaSeguridadUsuarioCommand = CommandFactory.createAddZonaSeguridadUsuarioCommand(_user, getHandler());
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
        _logger.debug( "Leaving CreateUserCommand.execute");
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
