package com.ucab.cmcapp.logic.commands.puntoControl.composite;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.AddPuntoControlCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatePuntoControlCommand extends Command<PuntoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( CreatePuntoControlCommand.class );
    private PuntoControl _user;
    private PuntoControl _result;
    private AddPuntoControlCommand _addPuntoControlCommand;

    public CreatePuntoControlCommand(PuntoControl user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePuntoControlCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreatePuntoControlCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePuntoControlCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addPuntoControlCommand = CommandFactory.createAddPuntoControlCommand(_user, getHandler());
            _addPuntoControlCommand.execute();
            _result = _addPuntoControlCommand.getReturnParam();
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
    public PuntoControl getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
