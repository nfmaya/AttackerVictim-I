package com.ucab.cmcapp.logic.commands.UserType.atomic;

import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserTypeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteUserTypeByIdCommand extends Command<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteUserTypeByIdCommand.class );
    private UserType _UserType;
    private UserTypeDao _dao;

    public DeleteUserTypeByIdCommand( UserType UserType, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteUserTypeByIdCommand.ctor: parameter {%s}",
                UserType.toString() ) );
        setHandler(handler);
        _UserType = UserType;
        _dao = DaoFactory.createUserTypeDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteUserTypeByIdCommand.ctor: attribute {%s}",
                _UserType.toString() ) );
        //endregion
    }

    public DeleteUserTypeByIdCommand( UserType UserType )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteUserTypeByIdCommand.ctor: parameter {%s}",
                UserType.toString() ) );
        _UserType = UserType;
        setHandler(new DBHandler());
        _dao = DaoFactory.createUserTypeDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteUserTypeByIdCommand.ctor: attribute {%s}",
                _UserType.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteUserTypeByIdCommand.execute" );

        //endregion
        _dao.delete( _UserType);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteUserTypeByIdCommand.execute" );
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
