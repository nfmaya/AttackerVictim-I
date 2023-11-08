package com.ucab.cmcapp.logic.commands.alerta.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.AddUserCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.logic.commands.alerta.atomic.DeleteAlertaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteAlertaCommand.class );
    private Alerta _user;
    private Alerta _result;
    private DeleteAlertaByIdCommand _addAlertaCommand;

    public DeleteAlertaCommand(Alerta user )
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
            _addAlertaCommand = CommandFactory.createDeleteAlertaByIdCommand(_user, getHandler());
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
