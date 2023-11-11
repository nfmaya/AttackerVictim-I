package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteUsuarioByIdCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteUsuarioByIdCommand.class );
    private Usuario _usuario;
    private UsuarioDao _dao;

    public DeleteUsuarioByIdCommand( Usuario usuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteUsuarioByIdCommand.ctor: parameter {%s}",
                usuario.toString() ) );
        setHandler(handler);
        _usuario = usuario;
        _dao = DaoFactory.createUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteUsuarioByIdCommand.ctor: attribute {%s}",
                _usuario.toString() ) );
        //endregion
    }

    public DeleteUsuarioByIdCommand( Usuario usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteUsuarioByIdCommand.ctor: parameter {%s}",
                usuario.toString() ) );
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteUsuarioByIdCommand.ctor: attribute {%s}",
                _usuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteUsuarioByIdCommand.execute" );

        //endregion
        _dao.delete( _usuario);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteUsuarioByIdCommand.execute" );
        //endregion
    }

    @Override
    public Usuario getReturnParam()
    {
        return _usuario;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
