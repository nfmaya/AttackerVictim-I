package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetCoordenadaZonaSeguridadByIdCommand extends Command<CoordenadaZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( GetCoordenadaZonaSeguridadByIdCommand.class );
    private long _idCoordenadaZonaSeguridad;
    private CoordenadaZonaSeguridad _result;
    private CoordenadaZonaSeguridadDao _dao;

    public GetCoordenadaZonaSeguridadByIdCommand(DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetCoordenadaZonaSeguridadByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idCoordenadaZonaSeguridad = userId;
        setHandler(handler);
        _dao = DaoFactory.createCoordenadaZonaSeguridadDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetCoordenadaZonaSeguridadByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetCoordenadaZonaSeguridadByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idCoordenadaZonaSeguridad, CoordenadaZonaSeguridad.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetCoordenadaZonaSeguridadByIdCommand.execute" );
        //endregion
    }

    @Override
    public CoordenadaZonaSeguridad getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
