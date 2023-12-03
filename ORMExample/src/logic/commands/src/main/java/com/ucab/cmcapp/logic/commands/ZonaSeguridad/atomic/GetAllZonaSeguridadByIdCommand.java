package com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadDao;

import java.util.List;

public class GetAllZonaSeguridadByIdCommand extends Command<ZonaSeguridad> {

    private List<ZonaSeguridad> _result;
    private ZonaSeguridadDao _dao;

    public GetAllZonaSeguridadByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguridadDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(ZonaSeguridad.class);
    }

    @Override
    public List<ZonaSeguridad> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
