package com.ucab.cmcapp.logic.commands.ZonaSeguridad.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridad.atomic.GetAllZonaSeguridadByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllZonaSeguridadCommand extends Command<ZonaSeguridad> {

    private List<ZonaSeguridad> _ZonaSeguridad;
    private GetAllZonaSeguridadByIdCommand _getAllZonaSeguridadListCommand;

    public GetAllZonaSeguridadCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllZonaSeguridadListCommand = CommandFactory.createGetAllZonaSeguridadByIdCommand(getHandler());
            _getAllZonaSeguridadListCommand.execute();
            _ZonaSeguridad = _getAllZonaSeguridadListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<ZonaSeguridad> getReturnParam() {
        return _ZonaSeguridad;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
