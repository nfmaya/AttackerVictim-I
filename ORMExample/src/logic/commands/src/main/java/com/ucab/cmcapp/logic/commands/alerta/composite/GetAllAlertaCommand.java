package com.ucab.cmcapp.logic.commands.alerta.composite;

import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.alerta.atomic.GetAllAlertaByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllAlertaCommand extends Command<Alerta> {

    private List<Alerta> _Alerta;
    private GetAllAlertaByIdCommand _getAllAlertaListCommand;

    public GetAllAlertaCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllAlertaListCommand = CommandFactory.createGetAllAlertaByIdCommand(getHandler());
            _getAllAlertaListCommand.execute();
            _Alerta = _getAllAlertaListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Alerta> getReturnParam() {
        return _Alerta;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
