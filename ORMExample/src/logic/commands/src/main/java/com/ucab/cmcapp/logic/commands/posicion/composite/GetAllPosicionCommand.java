package com.ucab.cmcapp.logic.commands.posicion.composite;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.posicion.atomic.GetAllPosicionByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;

import java.util.List;

public class GetAllPosicionCommand extends Command<Posicion> {

    private List<Posicion> _Posicion;
    private GetAllPosicionByIdCommand _getAllPosicionListCommand;

    private long _id;

    public GetAllPosicionCommand(long id) {

        _id = id;
        setHandler(new DBHandler());
    }

    @Override
    public void execute() {
        try {
            _getAllPosicionListCommand = CommandFactory.createGetAllPosicionByIdCommand(getHandler(),_id);
            _getAllPosicionListCommand.execute();
            _Posicion = _getAllPosicionListCommand.getReturnParam();
        } catch (Exception e) {
            getHandler().rollbackTransaction();
            getHandler().closeSession();
            throw e;
        }
    }

    @Override
    public List<Posicion> getReturnParam() {
        return _Posicion;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
