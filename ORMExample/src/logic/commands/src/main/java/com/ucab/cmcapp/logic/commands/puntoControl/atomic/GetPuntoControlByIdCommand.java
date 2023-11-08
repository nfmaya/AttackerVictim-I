package com.ucab.cmcapp.logic.commands.puntoControl.atomic;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PuntoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class GetPuntoControlByIdCommand extends Command<PuntoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( GetPuntoControlByIdCommand.class );
    private long _idPuntoControl;
    private PuntoControl _result;
    private PuntoControlDao _dao;

    public GetPuntoControlByIdCommand( DBHandler handler, long userId )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in GetPuntoControlByIdCommand.ctor: parameter {%s}", userId ) );
        //endregion

        _idPuntoControl = userId;
        setHandler(handler);
        _dao = DaoFactory.createPuntoControlDao(getHandler());

        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving GetPuntoControlByIdCommand.ctor: attribute {%s}", userId ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  GetPuntoControlByIdCommand.execute" );
        //endregion
        _result = _dao.find(_idPuntoControl, PuntoControl.class);
        //region Instrumentation DEBUG
        _logger.debug( "Leaving  GetPuntoControlByIdCommand.execute" );
        //endregion
    }

    @Override
    public PuntoControl getReturnParam()
    {
        return _result;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
