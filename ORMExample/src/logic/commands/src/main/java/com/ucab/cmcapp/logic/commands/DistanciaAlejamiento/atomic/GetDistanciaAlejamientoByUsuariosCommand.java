package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetDistanciaAlejamientoByUsuariosCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDistanciaAlejamientoByUsuariosCommand.class );
    private List<DistanciaAlejamiento> _distancia;
    private DistanciaAlejamientoDao _dao;

    private long _IdAlej;

    public GetDistanciaAlejamientoByUsuariosCommand(DBHandler handler , long id)
    {
        //region Instrumentation DEBUG
        _IdAlej = id;
        setHandler(handler);
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());

        //region Instrumentation DEBUG
        //endregion
    }


    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
        _distancia = _dao.getDistanciaAlejamientoByUsuarios(_IdAlej);
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetDistanciaAlejamientoByUsuariosCommand.execute" );
        //endregion
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
