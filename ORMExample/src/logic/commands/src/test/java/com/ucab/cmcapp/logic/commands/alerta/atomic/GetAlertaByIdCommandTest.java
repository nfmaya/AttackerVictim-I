package com.ucab.cmcapp.logic.commands.alerta.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class GetAlertaByIdCommandTest {

    private GetAlertaByIdCommand getAlertaByIdCommand;

    @Before
    public void setUp() {
        getAlertaByIdCommand = Mockito.mock(GetAlertaByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(getAlertaByIdCommand).execute();

        getAlertaByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(getAlertaByIdCommand).execute();

        getAlertaByIdCommand.execute();
    }
}