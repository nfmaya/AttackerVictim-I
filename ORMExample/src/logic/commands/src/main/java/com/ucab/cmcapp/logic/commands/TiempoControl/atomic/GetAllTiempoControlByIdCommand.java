package com.ucab.cmcapp.logic.commands.TiempoControl.atomic;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.TiempoControlDao;

import java.util.List;

public class GetAllTiempoControlByIdCommand extends Command<TiempoControl> {

    private List<TiempoControl> _result;
    private TiempoControlDao _dao;

    public GetAllTiempoControlByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createTiempoControlDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(TiempoControl.class);
    }

    @Override
    public List<TiempoControl> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
