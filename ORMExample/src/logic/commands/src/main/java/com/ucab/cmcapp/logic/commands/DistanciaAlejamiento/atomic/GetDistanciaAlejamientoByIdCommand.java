package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetDistanciaAlejamientoByIdCommand extends Command<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( GetDistanciaAlejamientoByIdCommand.class );
    private long _IdAlej;
    private DistanciaAlejamiento _result;
    private DistanciaAlejamientoDao _dao;

    public GetDistanciaAlejamientoByIdCommand( DBHandler handler, long IdAlej )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetDistanciaAlejamientoByIdCommand.ctor: parameter {%s}", IdAlej ) );
        //endregion

        _IdAlej = IdAlej;
        setHandler(handler);
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetDistanciaAlejamientoByIdCommand.ctor: attribute {%s}", IdAlej ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetDistanciaAlejamientoByIdCommand.execute" );
        //endregion
        _result = _dao.find(_IdAlej, DistanciaAlejamiento.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetDistanciaAlejamientoByIdCommand.execute" );
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
