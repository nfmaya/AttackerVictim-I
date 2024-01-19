package com.ucab.cmcapp.logic.commands.UserType.atomic;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserTypeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserTypeByIdCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( GetUserTypeByIdCommand.class );
    private long _idUserType;
    private UserType _result;
    private UserTypeDao _dao;

    public GetUserTypeByIdCommand(DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetUserTypeByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idUserType = userId;
        setHandler(handler);
        _dao = DaoFactory.createUserTypeDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetUserTypeByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetUserTypeByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idUserType, UserType.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetUserTypeByIdCommand.execute" );
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
