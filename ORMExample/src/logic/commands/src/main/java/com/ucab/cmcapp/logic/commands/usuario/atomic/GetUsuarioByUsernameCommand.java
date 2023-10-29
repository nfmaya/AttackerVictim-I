package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioByUsernameCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioByUsernameCommand.class );
    private Usuario _usuario;
    private UsuarioDao _dao;

    public GetUsuarioByUsernameCommand(Usuario usuario )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByUsernameCommand.ctor: parameter {%s}", usuario.toString() ) );
        _usuario = usuario;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetUsuarioByUsernameCommand.ctor: atribute {%s}", _usuario.toString() ) );
        //endregion
    }

    public GetUsuarioByUsernameCommand(Usuario usuario, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioByUsernameCommand.ctor: parameter {%s}", usuario.toString() ) );
        _usuario = usuario;
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetUsuarioByUsernameCommand.ctor: atribute {%s}", _usuario.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUsuarioByUsernameCommand.execute" );
        //endregion
        _usuario = _dao.getUsuarioByUsername(_usuario.get_Username());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetUsuarioByUsernameCommand.execute" );
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
