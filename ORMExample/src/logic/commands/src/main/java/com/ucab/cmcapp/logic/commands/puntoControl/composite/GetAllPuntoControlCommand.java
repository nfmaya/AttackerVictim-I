package com.ucab.cmcapp.logic.commands.puntoControl.composite;

import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.puntoControl.atomic.GetAllPuntoControlByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllPuntoControlCommand extends Command<PuntoControl> {

    private List<PuntoControl> _PuntoControl;
    private GetAllPuntoControlByIdCommand _getAllPuntoControlListCommand;

    public GetAllPuntoControlCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllPuntoControlListCommand = CommandFactory.createGetAllPuntoControlByIdCommand(getHandler());
            _getAllPuntoControlListCommand.execute();
            _PuntoControl = _getAllPuntoControlListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<PuntoControl> getReturnParam() {
        return _PuntoControl;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
