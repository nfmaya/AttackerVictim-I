package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteZonaSeguridadUsuarioByIdCommand extends Command<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteZonaSeguridadUsuarioByIdCommand.class );
    private ZonaSeguridadUsuario _ZonaSeguridadUsuario;
    private ZonaSeguridadUsuarioDao _dao;

    public DeleteZonaSeguridadUsuarioByIdCommand( ZonaSeguridadUsuario ZonaSeguridadUsuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguridadUsuarioByIdCommand.ctor: parameter {%s}",
                ZonaSeguridadUsuario.toString() ) );
        setHandler(handler);
        _ZonaSeguridadUsuario = ZonaSeguridadUsuario;
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguridadUsuarioByIdCommand.ctor: attribute {%s}",
                _ZonaSeguridadUsuario.toString() ) );
        //endregion
    }

    public DeleteZonaSeguridadUsuarioByIdCommand( ZonaSeguridadUsuario ZonaSeguridadUsuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteZonaSeguridadUsuarioByIdCommand.ctor: parameter {%s}",
                ZonaSeguridadUsuario.toString() ) );
        _ZonaSeguridadUsuario = ZonaSeguridadUsuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteZonaSeguridadUsuarioByIdCommand.ctor: attribute {%s}",
                _ZonaSeguridadUsuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguridadUsuarioByIdCommand.execute" );

        //endregion
        _dao.delete( _ZonaSeguridadUsuario);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteZonaSeguridadUsuarioByIdCommand.execute" );
        //endregion
    }

    @Override
    public ZonaSeguridadUsuario getReturnParam()
    {
        return _ZonaSeguridadUsuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
