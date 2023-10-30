package com.ucab.cmcapp.logic.commands.alerta.composite;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAlertaByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAlertaCommand.class );
    private Alerta _alerta;
    long _id;

    public GetAlertaCommand( Alerta alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaCommand.ctor: parameter {%s}",
                alerta.toString() ) );
        _id = alerta.get_IdAlerta();
        _alerta = alerta;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetAlertaCommand.ctor: attribute {%s}",
                _alerta.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetAlertaByIdCommand getAlertaByIdCommand = CommandFactory.createGetAlertaByIdCommand(getHandler(), _id);
            getAlertaByIdCommand.execute();
            _alerta = getAlertaByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Alerta getReturnParam()
    {
        return _alerta;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
