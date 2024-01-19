package com.ucab.cmcapp.logic.commands.posicion.composite;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.atomic.GetPosicionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetPosicionCommand extends Command<Posicion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPosicionCommand.class );
    private Posicion _user;
    long _id;

    public GetPosicionCommand( Posicion user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPosicionCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getIdPos();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPosicionCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetPosicionByIdCommand getPosicionByIdCommand = CommandFactory.createGetPosicionByIdCommand(getHandler(), _id);
            getPosicionByIdCommand.execute();
            _user = getPosicionByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Posicion getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
