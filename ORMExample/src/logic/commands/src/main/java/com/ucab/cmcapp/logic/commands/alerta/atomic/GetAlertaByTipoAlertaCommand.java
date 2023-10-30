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

public class GetAlertaByTipoAlertaCommand extends Command<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( GetAlertaByTipoAlertaCommand.class );
    private Alerta _alerta;
    private AlertaDao _dao;

    public GetAlertaByTipoAlertaCommand(Alerta alerta )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByTipoAlertaCommand.ctor: parameter {%s}", alerta.toString() ) );
        _alerta = alerta;
        setHandler(new DBHandler());
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetAlertaByTipoAlertaCommand.ctor: atribute {%s}", _alerta.toString() ) );
        //endregion
    }

    public GetAlertaByTipoAlertaCommand(Alerta alerta, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetAlertaByTipoAlertaCommand.ctor: parameter {%s}", alerta.toString() ) );
        _alerta = alerta;
        setHandler(handler);
        _dao = DaoFactory.createAlertaDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leavin GetAlertaByTipoAlertaCommand.ctor: atribute {%s}", _alerta.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetAlertaByTipoAlertaCommand.execute" );
        //endregion
        _alerta = _dao.getAlertaByTipoAlerta(_alerta.get_tipoAlerta());
        //region Instrumentation DEBUG
        _logger.debug( "Leavin  GetAlertaByTipoAlertaCommand.execute" );
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
