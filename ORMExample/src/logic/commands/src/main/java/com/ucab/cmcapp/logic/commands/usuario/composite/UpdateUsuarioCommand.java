package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.DeleteUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.atomic.UpdateUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUsuarioCommand extends Command<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateUsuarioCommand.class );
    private Usuario _user;
    private Usuario _result;
    private UpdateUsuarioByIdCommand _addUsuarioCommand;

    public UpdateUsuarioCommand(Usuario user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteUsuarioCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteUsuarioCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering DeleteUsuarioCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUsuarioCommand = CommandFactory.createUpdateUsuarioByIdCommand(_user, getHandler());
            _addUsuarioCommand.execute();
            _result = _addUsuarioCommand.getReturnParam();
            getHandler().finishTransaction();
            getHandler().closeSession();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving DeleteUsuarioCommand.execute");
        //endregion
    }

    @Override
    public Usuario getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
