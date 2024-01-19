package com.ucab.cmcapp.logic.commands.alerta.composite;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.atomic.DeleteAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.UpdateAlertaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateAlertaCommand.class );
    private Alerta _user;
    private Alerta _result;
    private UpdateAlertaByIdCommand _addAlertaCommand;

    public UpdateAlertaCommand(Alerta user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteAlertaCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteAlertaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteAlertaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addAlertaCommand = CommandFactory.createUpdateAlertaByIdCommand(_user, getHandler());
            _addAlertaCommand.execute();
            _result = _addAlertaCommand.getReturnParam();
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
        _logger.debug( "Leaving DeleteAlertaCommand.execute");
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
