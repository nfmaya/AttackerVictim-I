package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.DistanciaAlejamientoDao;

import java.util.List;

public class GetAllDistanciaAlejamientoByIdCommand extends Command<DistanciaAlejamiento> {

    private List<DistanciaAlejamiento> _result;
    private DistanciaAlejamientoDao _dao;

    public GetAllDistanciaAlejamientoByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createDistanciaAlejamientoDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(DistanciaAlejamiento.class);
    }

    @Override
    public List<DistanciaAlejamiento> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
