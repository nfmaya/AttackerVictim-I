package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class UpdateCoordenadaZonaSeguridadByIdCommandTest {

    private UpdateCoordenadaZonaSeguridadByIdCommand updateCoordenadaZonaSeguridadByIdCommand;

    @Before
    public void setUp() {
        updateCoordenadaZonaSeguridadByIdCommand = Mockito.mock(UpdateCoordenadaZonaSeguridadByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(updateCoordenadaZonaSeguridadByIdCommand).execute();

        updateCoordenadaZonaSeguridadByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(updateCoordenadaZonaSeguridadByIdCommand).execute();

        updateCoordenadaZonaSeguridadByIdCommand.execute();
    }
}