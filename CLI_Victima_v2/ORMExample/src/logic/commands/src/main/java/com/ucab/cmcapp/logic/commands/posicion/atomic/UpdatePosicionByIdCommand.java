package com.ucab.cmcapp.logic.commands.posicion.atomic;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePosicionByIdCommand extends Command<Posicion>
{
    private static Logger _logger = LoggerFactory.getLogger( UpdatePosicionByIdCommand.class );
    private Posicion _Posicion;
    private PosicionDao _dao;

    public UpdatePosicionByIdCommand(Posicion Posicion, DBHandler handler )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdatePosicionByIdCommand.ctor: parameter {%s}",
                Posicion.toString() ) );
        setHandler(handler);
        _Posicion = Posicion;
        _dao = DaoFactory.createPosicionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdatePosicionByIdCommand.ctor: attribute {%s}",
                _Posicion.toString() ) );
        //endregion
    }

    public UpdatePosicionByIdCommand(Posicion Posicion )
    {
        //region Instrumentation DEBUG
        _logger.debug( String.format( "Get in UpdatePosicionByIdCommand.ctor: parameter {%s}",
                Posicion.toString() ) );
        _Posicion = Posicion;
        setHandler(new DBHandler());
        _dao = DaoFactory.createPosicionDao(getHandler());


        //region Instrumentation DEBUG
        _logger.debug( String.format( "Leaving UpdatePosicionByIdCommand.ctor: attribute {%s}",
                _Posicion.toString() ) );
        //endregion
    }

    @Override
    public void execute()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdatePosicionByIdCommand.execute" );
        //endregion

        _dao.update( _Posicion);


        //region Instrumentation DEBUG
        _logger.debug( "Get in  UpdatePosicionByIdCommand.execute" );
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
