package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( AddAlertaCommand.class );
    private Alerta _alerta;
    private AlertaDao _dao;

    public AddAlertaCommand( Alerta alerta, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddAlertaCommand.ctor: parameter {%s}",
                alerta.toString() ) );
        setHandler(handler);
        _alerta = alerta;
        _dao = DaoFactory.createAlertaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddAlertaCommand.ctor: attribute {%s}",
                _alerta.toString() ) );
        //endregion
    }

    public AddAlertaCommand( Alerta alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddAlertaCommand.ctor: parameter {%s}",
                alerta.toString() ) );
        _alerta = alerta;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAlertaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddAlertaCommand.ctor: attribute {%s}",
                _alerta.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddAlertaCommand.execute" );
        //endregion

        _alerta = _dao.insert( _alerta);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddUserCommand.execute" );
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _alerta;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
