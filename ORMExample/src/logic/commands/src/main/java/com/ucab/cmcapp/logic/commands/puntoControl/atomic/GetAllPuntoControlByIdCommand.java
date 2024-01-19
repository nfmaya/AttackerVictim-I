package com.ucab.cmcapp.logic.commands.puntoControl.atomic;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.PuntoControlDao;

import java.util.List;

public class GetAllPuntoControlByIdCommand extends Command<PuntoControl> {

    private List<PuntoControl> _result;
    private PuntoControlDao _dao;

    public GetAllPuntoControlByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createPuntoControlDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(PuntoControl.class);
    }

    @Override
    public List<PuntoControl> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
