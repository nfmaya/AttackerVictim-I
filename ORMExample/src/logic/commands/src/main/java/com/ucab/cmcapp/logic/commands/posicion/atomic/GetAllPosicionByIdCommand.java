package com.ucab.cmcapp.logic.commands.posicion.atomic;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PosicionDao;

import java.util.List;

public class GetAllPosicionByIdCommand extends Command<Posicion> {

    private List<Posicion> _result;
    private PosicionDao _dao;

    private long idPosicion;

    public GetAllPosicionByIdCommand(DBHandler handler, long id) {
        idPosicion = id;
        setHandler(handler);
        _dao = DaoFactory.createPosicionDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.getPosicionByIdUsuario(idPosicion);
    }

    @Override
    public List<Posicion> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
