package com.ucab.cmcapp.logic.commands.TiempoControl.atomic;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteTiempoControlByIdCommand extends Command<TiempoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( DeleteTiempoControlByIdCommand.class );
    private TiempoControl _TiempoControl;
    private TiempoControlDao _dao;

    public DeleteTiempoControlByIdCommand( TiempoControl TiempoControl, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteTiempoControlByIdCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        setHandler(handler);
        _TiempoControl = TiempoControl;
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteTiempoControlByIdCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    public DeleteTiempoControlByIdCommand( TiempoControl TiempoControl )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeleteTiempoControlByIdCommand.ctor: parameter {%s}",
                TiempoControl.toString() ) );
        _TiempoControl = TiempoControl;
        setHandler(new DBHandler());
        _dao = DaoFactory.createTiempoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeleteTiempoControlByIdCommand.ctor: attribute {%s}",
                _TiempoControl.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteTiempoControlByIdCommand.execute" );

        //endregion
        _dao.delete( _TiempoControl);
        //SI SE QUIERE ELIMINAR DE LA BD, SE PONE .delete()
        //AQUI HACE UN DELETE LOGICO: .update()

        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeleteTiempoControlByIdCommand.execute" );
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
