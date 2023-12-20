package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetZonaSeguridadUsuarioByIdCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( GetZonaSeguridadUsuarioByIdCommand.class );
    private long _idZonaSeguridadUsuario;
    private ZonaSeguridadUsuario _result;
    private ZonaSeguridadUsuarioDao _dao;

    public GetZonaSeguridadUsuarioByIdCommand(DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetZonaSeguridadUsuarioByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idZonaSeguridadUsuario = userId;
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetZonaSeguridadUsuarioByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetZonaSeguridadUsuarioByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idZonaSeguridadUsuario, ZonaSeguridadUsuario.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetZonaSeguridadUsuarioByIdCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridadUsuario getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
