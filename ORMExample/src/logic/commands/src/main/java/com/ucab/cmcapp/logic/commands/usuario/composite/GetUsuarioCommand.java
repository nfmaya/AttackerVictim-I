package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.user.atomic.GetUserByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsuarioCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( GetUsuarioCommand.class );
    private Usuario _user;
    long _id;

    public GetUsuarioCommand( Usuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUsuarioCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.get_idUsuario();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUsuarioCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetUsuarioByIdCommand getUsuarioByIdCommand = CommandFactory.createGetUsuarioByIdCommand(getHandler(), _id);
            getUsuarioByIdCommand.execute();
            _user = getUsuarioByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public Usuario getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
