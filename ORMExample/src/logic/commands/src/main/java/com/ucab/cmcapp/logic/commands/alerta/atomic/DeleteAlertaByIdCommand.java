package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.BaseDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAlertaByIdCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteAlertaByIdCommand.class );
    private Alerta _Alerta;
    private AlertaDao _dao;

    public DeleteAlertaByIdCommand( Alerta Alerta, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteAlertaByIdCommand.ctor: parameter {%s}",
                Alerta.toString() ) );
        setHandler(handler);
        _Alerta = Alerta;
        _dao = DaoFactory.createAlertaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteAlertaByIdCommand.ctor: attribute {%s}",
                _Alerta.toString() ) );
        //endregion
    }

    public DeleteAlertaByIdCommand( Alerta Alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteAlertaByIdCommand.ctor: parameter {%s}",
                Alerta.toString() ) );
        _Alerta = Alerta;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAlertaDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteAlertaByIdCommand.ctor: attribute {%s}",
                _Alerta.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteAlertaByIdCommand.execute" );

        //endregion
        _dao.delete( _Alerta);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteAlertaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _Alerta;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
