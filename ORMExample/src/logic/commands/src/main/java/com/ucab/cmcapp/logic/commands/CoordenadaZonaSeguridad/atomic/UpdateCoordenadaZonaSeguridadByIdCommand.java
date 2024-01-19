package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateCoordenadaZonaSeguridadByIdCommand extends Command<CoordenadaZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateCoordenadaZonaSeguridadByIdCommand.class );
    private CoordenadaZonaSeguridad _CoordenadaZonaSeguridad;
    private CoordenadaZonaSeguridadDao _dao;

    public UpdateCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateCoordenadaZonaSeguridadByIdCommand.ctor: parameter {%s}",
                CoordenadaZonaSeguridad.toString() ) );
        setHandler(handler);
        _CoordenadaZonaSeguridad = CoordenadaZonaSeguridad;
        _dao = DaoFactory.createCoordenadaZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateCoordenadaZonaSeguridadByIdCommand.ctor: attribute {%s}",
                _CoordenadaZonaSeguridad.toString() ) );
        //endregion
    }

    public UpdateCoordenadaZonaSeguridadByIdCommand(CoordenadaZonaSeguridad CoordenadaZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateCoordenadaZonaSeguridadByIdCommand.ctor: parameter {%s}",
                CoordenadaZonaSeguridad.toString() ) );
        _CoordenadaZonaSeguridad = CoordenadaZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createCoordenadaZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateCoordenadaZonaSeguridadByIdCommand.ctor: attribute {%s}",
                _CoordenadaZonaSeguridad.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateCoordenadaZonaSeguridadByIdCommand.execute" );
        //endregion

        _dao.update( _CoordenadaZonaSeguridad);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateCoordenadaZonaSeguridadByIdCommand.execute" );
        //endregion
    }

    @Override
    public CoordenadaZonaSeguridad getReturnParam()
    {
        return _CoordenadaZonaSeguridad;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
