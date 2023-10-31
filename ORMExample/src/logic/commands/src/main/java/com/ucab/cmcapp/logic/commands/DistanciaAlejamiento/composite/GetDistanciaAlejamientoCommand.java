package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByIdCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDistanciaAlejamientoCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDistanciaAlejamientoCommand.class );
    private DistanciaAlejamiento _distancia;
    long _id;

    public GetDistanciaAlejamientoCommand( DistanciaAlejamiento distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDistanciaAlejamientoCommand.ctor: parameter {%s}",
                distancia.toString() ) );
        _id = distancia.get_IdAlej();
        _distancia = distancia;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDistanciaAlejamientoCommand.ctor: attribute {%s}",
                _distancia.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetDistanciaAlejamientoByIdCommand getDistanciaAlejamientoByIdCommand = CommandFactory.createGetDistanciaAlejamientoByIdCommand(getHandler(), _id);
            getDistanciaAlejamientoByIdCommand.execute();
            _distancia = getDistanciaAlejamientoByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public DistanciaAlejamiento getReturnParam()
    {
        return _distancia;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
