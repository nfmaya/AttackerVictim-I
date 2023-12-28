package com.ucab.cmcapp.logic.commands.alerta.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class GetAlertaByTipoAlertaCommandTest {

    private GetAlertaByTipoAlertaCommand getAlertaByTipoAlertaCommand;

    @Before
    public void setUp() {
        getAlertaByTipoAlertaCommand = Mockito.mock(GetAlertaByTipoAlertaCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(getAlertaByTipoAlertaCommand).execute();

        getAlertaByTipoAlertaCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(getAlertaByTipoAlertaCommand).execute();

        getAlertaByTipoAlertaCommand.execute();
    }
}