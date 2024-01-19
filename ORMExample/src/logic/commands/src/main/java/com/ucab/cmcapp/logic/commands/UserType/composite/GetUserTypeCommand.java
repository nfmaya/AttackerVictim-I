package com.ucab.cmcapp.logic.commands.UserType.composite;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.UserType.atomic.GetUserTypeByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserTypeCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( GetUserTypeCommand.class );
    private UserType _user;
    long _id;

    public GetUserTypeCommand( UserType user )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUserTypeCommand.ctor: parameter {%s}",
                user.toString() ) );
        _id = user.getId();
        _user = user;
        setHandler(new DBHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUserTypeCommand.ctor: attribute {%s}",
                _user.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        try
        {
            GetUserTypeByIdCommand getUserTypeByIdCommand = CommandFactory.createGetUserTypeByIdCommand(getHandler(), _id);
            getUserTypeByIdCommand.execute();
            _user = getUserTypeByIdCommand.getReturnParam();
        }
        catch (Exception e)
        {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public UserType getReturnParam()
    {
        return _user;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
