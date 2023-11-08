package com.ucab.cmcapp.logic.commands.puntoControl.atomic;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PuntoControlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeletePuntoControlByIdCommand extends Command<PuntoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( DeletePuntoControlByIdCommand.class );
    private PuntoControl _PuntoControl;
    private PuntoControlDao _dao;

    public DeletePuntoControlByIdCommand( PuntoControl PuntoControl, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeletePuntoControlByIdCommand.ctor: parameter {%s}",
                PuntoControl.toString() ) );
        setHandler(handler);
        _PuntoControl = PuntoControl;
        _dao = DaoFactory.createPuntoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeletePuntoControlByIdCommand.ctor: attribute {%s}",
                _PuntoControl.toString() ) );
        //endregion
    }

    public DeletePuntoControlByIdCommand( PuntoControl PuntoControl )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeletePuntoControlByIdCommand.ctor: parameter {%s}",
                PuntoControl.toString() ) );
        _PuntoControl = PuntoControl;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPuntoControlDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeletePuntoControlByIdCommand.ctor: attribute {%s}",
                _PuntoControl.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeletePuntoControlByIdCommand.execute" );

        //endregion
        _dao.delete( _PuntoControl);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeletePuntoControlByIdCommand.execute" );
        //endregion
    }

    @Override
    public PuntoControl getReturnParam()
    {
        return _PuntoControl;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
