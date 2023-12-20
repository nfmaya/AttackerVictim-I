package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByIdCommand;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetDistanciaAlejamientoByUsuariosCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetDistanciaAlejamientoUsuariosCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDistanciaAlejamientoUsuariosCommand.class );
    private List<DistanciaAlejamiento> _distancia;

    private GetDistanciaAlejamientoByUsuariosCommand getDistanciaAlejamientoByUsuariosCommand;
    long _id;

    public GetDistanciaAlejamientoUsuariosCommand(long id)
    {
        _id = id;
        setHandler(new DBHandler());


    }

    @Override
    public void execute()
    {
        try
        {
            getDistanciaAlejamientoByUsuariosCommand = CommandFactory.createGetDistanciaAlejamientoByUsuariosCommand(getHandler(), _id);
            getDistanciaAlejamientoByUsuariosCommand.execute();
            _distancia = getDistanciaAlejamientoByUsuariosCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<DistanciaAlejamiento> getReturnParam()
    {
        return _distancia;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
