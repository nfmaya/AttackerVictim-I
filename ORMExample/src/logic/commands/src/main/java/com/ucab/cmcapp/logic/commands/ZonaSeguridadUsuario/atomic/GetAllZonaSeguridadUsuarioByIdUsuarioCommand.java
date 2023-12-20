package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.ZonaSeguridadUsuarioDao;

import java.util.List;

public class GetAllZonaSeguridadUsuarioByIdUsuarioCommand extends Command<ZonaSeguridadUsuario> {

    private List<ZonaSeguridadUsuario> _result;
    private ZonaSeguridadUsuarioDao _dao;

    private long idZona;

    public GetAllZonaSeguridadUsuarioByIdUsuarioCommand(DBHandler handler, long id) {

        idZona = id;
        setHandler(handler);
        _dao = DaoFactory.createZonaSeguridadUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getZonaSeguridadUsuarioByIdUsuario(idZona);
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
