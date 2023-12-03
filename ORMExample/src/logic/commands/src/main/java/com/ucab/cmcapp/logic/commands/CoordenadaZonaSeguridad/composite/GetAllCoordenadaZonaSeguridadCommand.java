package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic.GetAllCoordenadaZonaSeguridadByIdZonaCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllCoordenadaZonaSeguridadCommand extends Command<CoordenadaZonaSeguridad> {

    private List<CoordenadaZonaSeguridad> _CoordenadaZonaSeguridad;
    private GetAllCoordenadaZonaSeguridadByIdZonaCommand _getAllCoordenadaZonaSeguridadListCommand;

    long _id;

    public GetAllCoordenadaZonaSeguridadCommand(long id)
    {
        //region Instrumentation DEBUG

        _id = id;

        setHandler(new DBHandler());

        //region Instrumentation DEBUG

        //endregion
    }

    @Override
    public void execute() {
        try {
            _getAllCoordenadaZonaSeguridadListCommand = CommandFactory.createGetAllCoordenadaZonaSeguridadByIdZonaCommand(getHandler(),_id);
            _getAllCoordenadaZonaSeguridadListCommand.execute();
            _CoordenadaZonaSeguridad = _getAllCoordenadaZonaSeguridadListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<CoordenadaZonaSeguridad> getReturnParam() {
        return _CoordenadaZonaSeguridad;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
