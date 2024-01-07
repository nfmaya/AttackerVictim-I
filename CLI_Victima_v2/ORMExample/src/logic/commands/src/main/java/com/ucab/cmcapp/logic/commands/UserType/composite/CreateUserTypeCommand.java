package com.ucab.cmcapp.logic.commands.UserType.composite;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.UserType.atomic.AddUserTypeCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserTypeCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( CreateUserTypeCommand.class );
    private UserType _user;
    private UserType _result;
    private AddUserTypeCommand _addUserTypeCommand;

    public CreateUserTypeCommand(UserType user )
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUserTypeCommand.ctor");
        //endregion

        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( "Leaving CreateUserTypeCommand.ctor");
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entering CreateUserTypeCommand.execute");
        //endregion

        try
        {
            getHandler().beginTransaction();
            _addUserTypeCommand = CommandFactory.createAddUserTypeCommand(_user, getHandler());
            _addUserTypeCommand.execute();
            _result = _addUserTypeCommand.getReturnParam();
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
    public UserType getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
