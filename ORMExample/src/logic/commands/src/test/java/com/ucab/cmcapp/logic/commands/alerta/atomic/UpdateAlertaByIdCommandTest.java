package com.ucab.cmcapp.logic.commands.alerta.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class UpdateAlertaByIdCommandTest {

    private UpdateAlertaByIdCommand updateAlertaByIdCommand;

    @Before
    public void setUp() {
        updateAlertaByIdCommand = Mockito.mock(UpdateAlertaByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(updateAlertaByIdCommand).execute();

        updateAlertaByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(updateAlertaByIdCommand).execute();

        updateAlertaByIdCommand.execute();
    }
}