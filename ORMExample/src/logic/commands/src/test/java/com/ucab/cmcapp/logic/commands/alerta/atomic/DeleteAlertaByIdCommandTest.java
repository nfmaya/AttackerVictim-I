package com.ucab.cmcapp.logic.commands.alerta.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DeleteAlertaByIdCommandTest {

    private DeleteAlertaByIdCommand deleteAlertaByIdCommand;

    @Before
    public void setUp() {
        deleteAlertaByIdCommand = Mockito.mock(DeleteAlertaByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(deleteAlertaByIdCommand).execute();

        deleteAlertaByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(deleteAlertaByIdCommand).execute();

        deleteAlertaByIdCommand.execute();
    }
}