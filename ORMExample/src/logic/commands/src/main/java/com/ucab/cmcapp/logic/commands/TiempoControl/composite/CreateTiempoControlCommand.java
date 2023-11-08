package com.ucab.cmcapp.logic.commands.TiempoControl.composite;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.atomic.AddTiempoControlCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTiempoControlCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateTiempoControlCommand.class );
    private TiempoControl _user;
    private TiempoControl _result;
    private AddTiempoControlCommand _addTiempoControlCommand;

    public CreateTiempoControlCommand(TiempoControl user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateTiempoControlCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateTiempoControlCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateTiempoControlCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addTiempoControlCommand = CommandFactory.createAddTiempoControlCommand(_user, getHandler());
            _addTiempoControlCommand.execute();
            _result = _addTiempoControlCommand.getReturnParam();
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
    public TiempoControl getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
