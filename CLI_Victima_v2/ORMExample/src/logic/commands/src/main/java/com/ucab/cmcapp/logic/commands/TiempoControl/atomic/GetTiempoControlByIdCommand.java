package com.ucab.cmcapp.logic.commands.TiempoControl.atomic;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTiempoControlByIdCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( GetTiempoControlByIdCommand.class );
    private long _idTiempoControl;
    private TiempoControl _result;
    private TiempoControlDao _dao;

    public GetTiempoControlByIdCommand(DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetTiempoControlByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idTiempoControl = userId;
        setHandler(handler);
        _dao = DaoFactory.createTiempoControlDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetTiempoControlByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetTiempoControlByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idTiempoControl, TiempoControl.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetTiempoControlByIdCommand.execute" );
        //endregion
    }

    @Override
    public TiempoControl getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
