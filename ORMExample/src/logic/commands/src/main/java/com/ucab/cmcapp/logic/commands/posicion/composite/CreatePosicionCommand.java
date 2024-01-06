package com.ucab.cmcapp.logic.commands.posicion.composite;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.atomic.AddPosicionCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatePosicionCommand extends Command<Posicion>
{
    private static Logger _logger = LoggerFactory.getLogger( CreatePosicionCommand.class );
    private Posicion _user;
    private Posicion _result;
    private AddPosicionCommand _addPosicionCommand;

    public CreatePosicionCommand(Posicion user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePosicionCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreatePosicionCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreatePosicionCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addPosicionCommand = CommandFactory.createAddPosicionCommand(_user, getHandler());
            _addPosicionCommand.execute();
            _result = _addPosicionCommand.getReturnParam();
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
        _logger.debug( "Leaving CreateUserCommand.execute");
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
