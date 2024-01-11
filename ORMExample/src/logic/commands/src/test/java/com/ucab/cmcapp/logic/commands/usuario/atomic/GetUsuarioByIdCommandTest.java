package com.ucab.cmcapp.logic.commands.usuario.atomic;


import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.UsuarioDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GetUsuarioByIdCommandTest {

    private DBHandler handler;
    private UsuarioDao dao;
    private GetUsuarioByIdCommand command;
    private Usuario usuario;

    @Before
    public void setUp() {
        handler = Mockito.mock(DBHandler.class);
        dao = Mockito.mock(UsuarioDao.class);
        usuario = new Usuario();
        usuario.set_idUsuario(1L);
        when(dao.find(1L, Usuario.class)).thenReturn(usuario);
    }

    @Test
    public void shouldReturnUsuarioWhenIdExists() {
        command = new GetUsuarioByIdCommand(handler, 1L);
        command.execute();
        assertEquals(usuario, command.getReturnParam());
    }

    @Test
    public void shouldReturnNullWhenIdDoesNotExist() {
        command = new GetUsuarioByIdCommand(handler, 2L);
        command.execute();
        assertEquals(null, command.getReturnParam());
    }
}
