package com.ucab.cmcapp.logic.commands.usuario.composite;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetAllUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllUsuarioCommand extends Command<Usuario> {

    private List<Usuario> _Usuario;
    private GetAllUsuarioByIdCommand _getAllUsuarioListCommand;

    public GetAllUsuarioCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllUsuarioListCommand = CommandFactory.createGetAllUsuarioByIdCommand(getHandler());
            _getAllUsuarioListCommand.execute();
            _Usuario = _getAllUsuarioListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Usuario> getReturnParam() {
        return _Usuario;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
