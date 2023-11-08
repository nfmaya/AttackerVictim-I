package com.ucab.cmcapp.logic.commands.posicion.atomic;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetPosicionByIdCommand extends Command<Posicion>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPosicionByIdCommand.class );
    private long _idPosicion;
    private Posicion _result;
    private PosicionDao _dao;

    public GetPosicionByIdCommand( DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPosicionByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idPosicion = userId;
        setHandler(handler);
        _dao = DaoFactory.createPosicionDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPosicionByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetPosicionByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idPosicion, Posicion.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPosicionByIdCommand.execute" );
        //endregion
    }

    @Override
    public Posicion getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
