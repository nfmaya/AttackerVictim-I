package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.AddDistanciaAlejamientoCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateDistanciaAlejamientoCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateDistanciaAlejamientoCommand.class );
    private DistanciaAlejamiento _distancia;
    private DistanciaAlejamiento _result;
    private AddDistanciaAlejamientoCommand _addDistanciaAlejamientoCommand;

    public CreateDistanciaAlejamientoCommand(DistanciaAlejamiento distancia )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateDistanciaAlejamientoCommand.ctor");
        //endregion

        _distancia = distancia;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateDistanciaAlejamientoCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateDistanciaAlejamientoCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addDistanciaAlejamientoCommand = CommandFactory.createAddDistanciaAlejamientoCommand(_distancia, getHandler());
            _addDistanciaAlejamientoCommand.execute();
            _result = _addDistanciaAlejamientoCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateDistanciaAlejamientoCommand.execute");
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
