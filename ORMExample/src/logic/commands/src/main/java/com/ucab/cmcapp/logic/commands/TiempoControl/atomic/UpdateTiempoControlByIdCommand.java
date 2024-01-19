package com.ucab.cmcapp.logic.commands.TiempoControl.atomic;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateTiempoControlByIdCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdateTiempoControlByIdCommand.class );
    private TiempoControl _TiempoControl;
    private TiempoControlDao _dao;

    public UpdateTiempoControlByIdCommand(TiempoControl TiempoControl, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateTiempoControlByIdCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        setHandler(handler);
        _TiempoControl = TiempoControl;
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateTiempoControlByIdCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    public UpdateTiempoControlByIdCommand(TiempoControl TiempoControl )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdateTiempoControlByIdCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        _TiempoControl = TiempoControl;
        setHandler(new DBHandler());
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdateTiempoControlByIdCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateTiempoControlByIdCommand.execute" );
        //endregion

        _dao.update( _TiempoControl);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdateTiempoControlByIdCommand.execute" );
        //endregion
    }

    @Override
    public TiempoControl getReturnParam()
    {
        return _TiempoControl;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
