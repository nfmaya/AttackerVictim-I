package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.CoordenadaZonaSeguridadDao;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;

import java.util.List;

public class GetAllCoordenadaZonaSeguridadByIdZonaCommand extends Command<CoordenadaZonaSeguridad> {

    private List<CoordenadaZonaSeguridad> _result;
    private CoordenadaZonaSeguridadDao _dao;

    private long idZona;

    public GetAllCoordenadaZonaSeguridadByIdZonaCommand(DBHandler handler,long id) {

        idZona = id;
        setHandler(handler);
        _dao = DaoFactory.createCoordenadaZonaSeguridadDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getCoordenadaZonaSeguridadByIdZona(idZona);
    }

    @Override
    public List<CoordenadaZonaSeguridad> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
