package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetAlertaByIdCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAlertaByIdCommand.class );
    private long _IdAlerta;
    private Alerta _result;
    private AlertaDao _dao;

    public GetAlertaByIdCommand( DBHandler handler, long IdAlerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByIdCommand.ctor: parameter {%s}", IdAlerta ) );
        //endregion

        _IdAlerta = IdAlerta;
        setHandler(handler);
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetAlertaByIdCommand.ctor: attribute {%s}", IdAlerta ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetAlertaByIdCommand.execute" );
        //endregion
        _result = _dao.find(_IdAlerta, Alerta.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetAlertaByIdCommand.execute" );
        //endregion
    }

    @Override
    public Alerta getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
