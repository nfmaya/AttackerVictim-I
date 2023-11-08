package com.ucab.cmcapp.logic.commands.UserType.atomic;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserTypeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUserTypeByIdCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateUserTypeByIdCommand.class );
    private UserType _UserType;
    private UserTypeDao _dao;

    public UpdateUserTypeByIdCommand(UserType UserType, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateUserTypeByIdCommand.ctor: parameter {%s}",
                UserType.toString() ) );
        setHandler(handler);
        _UserType = UserType;
        _dao = DaoFactory.createUserTypeDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateUserTypeByIdCommand.ctor: attribute {%s}",
                _UserType.toString() ) );
        //endregion
    }

    public UpdateUserTypeByIdCommand(UserType UserType )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateUserTypeByIdCommand.ctor: parameter {%s}",
                UserType.toString() ) );
        _UserType = UserType;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserTypeDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateUserTypeByIdCommand.ctor: attribute {%s}",
                _UserType.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateUserTypeByIdCommand.execute" );
        //endregion

        _dao.update( _UserType);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateUserTypeByIdCommand.execute" );
        //endregion
    }

    @Override
    public UserType getReturnParam()
    {
        return _UserType;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
