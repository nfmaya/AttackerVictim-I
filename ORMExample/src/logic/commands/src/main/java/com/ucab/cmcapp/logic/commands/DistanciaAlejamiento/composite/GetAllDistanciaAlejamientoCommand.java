package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.composite;

import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic.GetAllDistanciaAlejamientoByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllDistanciaAlejamientoCommand extends Command<DistanciaAlejamiento> {

    private List<DistanciaAlejamiento> _DistanciaAlejamiento;
    private GetAllDistanciaAlejamientoByIdCommand _getAllDistanciaAlejamientoListCommand;

    public GetAllDistanciaAlejamientoCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllDistanciaAlejamientoListCommand = CommandFactory.createGetAllDistanciaAlejamientoByIdCommand(getHandler());
            _getAllDistanciaAlejamientoListCommand.execute();
            _DistanciaAlejamiento = _getAllDistanciaAlejamientoListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<DistanciaAlejamiento> getReturnParam() {
        return _DistanciaAlejamiento;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
