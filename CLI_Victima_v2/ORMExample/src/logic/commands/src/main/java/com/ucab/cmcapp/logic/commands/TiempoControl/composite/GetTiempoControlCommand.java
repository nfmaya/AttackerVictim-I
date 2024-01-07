package com.ucab.cmcapp.logic.commands.TiempoControl.composite;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.atomic.GetTiempoControlByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTiempoControlCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( GetTiempoControlCommand.class );
    private TiempoControl _user;
    long _id;

    public GetTiempoControlCommand( TiempoControl user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetTiempoControlCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdTiempo();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetTiempoControlCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetTiempoControlByIdCommand getTiempoControlByIdCommand = CommandFactory.createGetTiempoControlByIdCommand(getHandler(), _id);
            getTiempoControlByIdCommand.execute();
            _user = getTiempoControlByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public TiempoControl getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
