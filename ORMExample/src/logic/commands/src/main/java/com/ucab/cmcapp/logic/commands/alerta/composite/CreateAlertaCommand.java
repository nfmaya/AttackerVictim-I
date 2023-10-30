package com.ucab.cmcapp.logic.commands.alerta.composite;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateAlertaCommand.class );
    private Alerta _alerta;
    private Alerta _result;
    private AddAlertaCommand _addAlertaCommand;

    public CreateAlertaCommand(Alerta alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateAlertaCommand.ctor");
        //endregion

        _alerta = alerta;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateAlertaCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateAlertaCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addAlertaCommand = CommandFactory.createAddAlertaCommand(_alerta, getHandler());
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
        _logger.debug( "Leaving CreateAlertaCommand.execute");
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
