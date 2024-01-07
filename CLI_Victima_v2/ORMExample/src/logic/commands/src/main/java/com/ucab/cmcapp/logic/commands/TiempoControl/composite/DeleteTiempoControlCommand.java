package com.ucab.cmcapp.logic.commands.TiempoControl.composite;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.atomic.DeleteTiempoControlByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteTiempoControlCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteTiempoControlCommand.class );
    private TiempoControl _user;
    private TiempoControl _result;
    private DeleteTiempoControlByIdCommand _addTiempoControlCommand;

    public DeleteTiempoControlCommand(TiempoControl user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteTiempoControlCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteTiempoControlCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteTiempoControlCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addTiempoControlCommand = CommandFactory.createDeleteTiempoControlByIdCommand(_user, getHandler());
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
        _logger.debug( "Leaving DeleteTiempoControlCommand.execute");
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
