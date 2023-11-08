package com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguridadByIdCommand extends Command<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguridadByIdCommand.class );
    private ZonaSeguridad _ZonaSeguridad;
    private ZonaSeguridadDao _dao;

    public DeleteZonaSeguridadByIdCommand( ZonaSeguridad ZonaSeguridad, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguridadByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        setHandler(handler);
        _ZonaSeguridad = ZonaSeguridad;
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguridadByIdCommand.ctor: attribute {%s}",
                _ZonaSeguridad.toString() ) );
        //endregion
    }

    public DeleteZonaSeguridadByIdCommand( ZonaSeguridad ZonaSeguridad )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguridadByIdCommand.ctor: parameter {%s}",
                ZonaSeguridad.toString() ) );
        _ZonaSeguridad = ZonaSeguridad;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguridadByIdCommand.ctor: attribute {%s}",
                _ZonaSeguridad.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguridadByIdCommand.execute" );

        //endregion
        _dao.delete( _ZonaSeguridad);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguridadByIdCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridad getReturnParam()
    {
        return _ZonaSeguridad;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
