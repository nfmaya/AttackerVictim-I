package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByIdCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import org.junit.Test;
import org.mockito.Mockito;
import com.ucab.cmcapp.logic.commands.Command;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CommandFactoryTest {

    @Test
    public void testMockCreateGetUsuarioByIdCommand() {
        // Arrange
       // DBHandler handler = mock(DBHandler.class);

        long userId = 1;
        GetUsuarioByIdCommand mockCommand = mock(GetUsuarioByIdCommand.class);
        GetUsuarioCommand mockCompositeCommand = mock(GetUsuarioCommand.class);

        mockCompositeCommand.setHandler(new DBHandler());

        // Mock the method
       // Mockito.when(CommandFactory.createGetUsuarioByIdCommand(getHandler(), userId)).thenReturn(mockCommand);

        // Act
       // GetUsuarioByIdCommand command = CommandFactory.createGetUsuarioByIdCommand(getHandler(), userId);

        // Assert
       // assertEquals(mockCommand, command);
    }



}
