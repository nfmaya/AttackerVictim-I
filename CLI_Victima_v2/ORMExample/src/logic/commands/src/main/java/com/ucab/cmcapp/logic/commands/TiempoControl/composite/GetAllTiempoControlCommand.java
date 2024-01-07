package com.ucab.cmcapp.logic.commands.TiempoControl.composite;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.TiempoControl.atomic.GetAllTiempoControlByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllTiempoControlCommand extends Command<TiempoControl> {

    private List<TiempoControl> _TiempoControl;
    private GetAllTiempoControlByIdCommand _getAllTiempoControlListCommand;

    public GetAllTiempoControlCommand() {
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllTiempoControlListCommand = CommandFactory.createGetAllTiempoControlByIdCommand(getHandler());
            _getAllTiempoControlListCommand.execute();
            _TiempoControl = _getAllTiempoControlListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<TiempoControl> getReturnParam() {
        return _TiempoControl;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
