package com.ucab.cmcapp.logic.commands.posicion.atomic;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeletePosicionByIdCommand extends Command<Posicion>
{
    private static Logger _logger = LoggerFactory.getLogger( DeletePosicionByIdCommand.class );
    private Posicion _Posicion;
    private PosicionDao _dao;

    public DeletePosicionByIdCommand( Posicion Posicion, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeletePosicionByIdCommand.ctor: parameter {%s}",
                Posicion.toString() ) );
        setHandler(handler);
        _Posicion = Posicion;
        _dao = DaoFactory.createPosicionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeletePosicionByIdCommand.ctor: attribute {%s}",
                _Posicion.toString() ) );
        //endregion
    }

    public DeletePosicionByIdCommand( Posicion Posicion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in DeletePosicionByIdCommand.ctor: parameter {%s}",
                Posicion.toString() ) );
        _Posicion = Posicion;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPosicionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving DeletePosicionByIdCommand.ctor: attribute {%s}",
                _Posicion.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeletePosicionByIdCommand.execute" );

        //endregion
        _dao.delete( _Posicion);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  DeletePosicionByIdCommand.execute" );
        //endregion
    }

    @Override
    public Posicion getReturnParam()
    {
        return _Posicion;
    }

    @Override
    public void closeHandlerSession()
    {
        getHandler().closeSession();
    }
}
