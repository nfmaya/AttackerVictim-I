package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.DeleteDistanciaByIdCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.UpdateDistanciaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateDistanciaCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateDistanciaCommand.class );
    private DistanciaAlejamiento _user;
    private DistanciaAlejamiento _result;
    private UpdateDistanciaByIdCommand _addDistanciaCommand;

    public UpdateDistanciaCommand(DistanciaAlejamiento user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteDistanciaCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteDistanciaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteDistanciaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addDistanciaCommand = CommandFactory.createUpdateDistanciaByIdCommand(_user, getHandler());
            _addDistanciaCommand.execute();
            _result = _addDistanciaCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteDistanciaCommand.execute");
        //endregion
    }

    @Override
    public DistanciaAlejamiento getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
