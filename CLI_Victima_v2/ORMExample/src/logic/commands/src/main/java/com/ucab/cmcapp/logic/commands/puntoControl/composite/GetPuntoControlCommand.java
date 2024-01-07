package com.ucab.cmcapp.logic.commands.puntoControl.composite;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.GetPuntoControlByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPuntoControlCommand extends Command<PuntoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPuntoControlCommand.class );
    private PuntoControl _user;
    long _id;

    public GetPuntoControlCommand( PuntoControl user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPuntoControlCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdPos();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPuntoControlCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetPuntoControlByIdCommand getPuntoControlByIdCommand = CommandFactory.createGetPuntoControlByIdCommand(getHandler(), _id);
            getPuntoControlByIdCommand.execute();
            _user = getPuntoControlByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public PuntoControl getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
