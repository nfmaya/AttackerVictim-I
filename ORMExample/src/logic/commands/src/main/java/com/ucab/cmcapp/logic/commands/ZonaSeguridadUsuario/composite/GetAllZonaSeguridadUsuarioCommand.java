package com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.composite;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.ZonaSeguridadUsuario.atomic.GetAllZonaSeguridadUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllZonaSeguridadUsuarioCommand extends Command<ZonaSeguridadUsuario> {

    private List<ZonaSeguridadUsuario> _ZonaSeguridadUsuario;
    private GetAllZonaSeguridadUsuarioByIdCommand _getAllZonaSeguridadUsuarioListCommand;

    public GetAllZonaSeguridadUsuarioCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllZonaSeguridadUsuarioListCommand = CommandFactory.createGetAllZonaSeguridadUsuarioByIdCommand(getHandler());
            _getAllZonaSeguridadUsuarioListCommand.execute();
            _ZonaSeguridadUsuario = _getAllZonaSeguridadUsuarioListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<ZonaSeguridadUsuario> getReturnParam() {
        return _ZonaSeguridadUsuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
