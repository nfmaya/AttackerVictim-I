package com.ucab.cmcapp.logic.commands.TiempoControl.atomic;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddTiempoControlCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( AddTiempoControlCommand.class );
    private TiempoControl _TiempoControl;
    private TiempoControlDao _dao;

    public AddTiempoControlCommand( TiempoControl TiempoControl, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddTiempoControlCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        setHandler(handler);
        _TiempoControl = TiempoControl;
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddTiempoControlCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    public AddTiempoControlCommand( TiempoControl TiempoControl )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in AddTiempoControlCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        _TiempoControl = TiempoControl;
        setHandler(new DBHandler());
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving AddTiempoControlCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddTiempoControlCommand.execute" );
        //endregion

        _TiempoControl = _dao.insert( _TiempoControl);

        //region Instrumentation DEBUG
        _logger.debug( "Get in  AddTiempoControlCommand.execute" );
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
