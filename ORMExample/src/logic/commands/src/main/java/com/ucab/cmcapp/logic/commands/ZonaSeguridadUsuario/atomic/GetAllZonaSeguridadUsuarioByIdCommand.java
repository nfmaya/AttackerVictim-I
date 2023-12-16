package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;

import java.util.List;

public class GetAllZonaSeguridadUsuarioByIdCommand extends Command<ZonaSeguridadUsuario> {

    private List<ZonaSeguridadUsuario> _result;
    private ZonaSeguridadUsuarioDao _dao;

    public GetAllZonaSeguridadUsuarioByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(ZonaSeguridadUsuario.class);
    }

    @Override
    public List<ZonaSeguridadUsuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
