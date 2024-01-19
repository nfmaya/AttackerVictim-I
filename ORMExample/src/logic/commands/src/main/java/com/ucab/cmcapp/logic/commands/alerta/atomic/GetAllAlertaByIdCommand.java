package com.ucab.cmcapp.logic.commands.alerta.atomic;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;

import java.util.List;

public class GetAllAlertaByIdCommand extends Command<Alerta> {

    private List<Alerta> _result;
    private AlertaDao _dao;

    public GetAllAlertaByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createAlertaDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Alerta.class);
    }

    @Override
    public List<Alerta> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
