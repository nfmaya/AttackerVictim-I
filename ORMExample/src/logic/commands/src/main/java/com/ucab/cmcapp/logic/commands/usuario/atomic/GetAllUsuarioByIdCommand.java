package com.ucab.cmcapp.logic.commands.usuario.atomic;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.Command;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.UserDao;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;

import java.util.List;

public class GetAllUsuarioByIdCommand extends Command<Usuario> {

    private List<Usuario> _result;
    private UsuarioDao _dao;

    public GetAllUsuarioByIdCommand(DBHandler handler) {
        setHandler(handler);
        _dao = DaoFactory.createUsuarioDao(getHandler());
    }

    @Override
    public void execute() {
        _result = _dao.findAll(Usuario.class);
    }

    @Override
    public List<Usuario> getReturnParam() {
        return _result;
    }

    @Override
    public void closeHandlerSession() {
        getHandler().closeSession();
    }

}
