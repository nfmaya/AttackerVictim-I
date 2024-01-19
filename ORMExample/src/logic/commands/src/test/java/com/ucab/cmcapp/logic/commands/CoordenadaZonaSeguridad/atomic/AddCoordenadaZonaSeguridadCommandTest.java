package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class AddCoordenadaZonaSeguridadCommandTest {

    private AddCoordenadaZonaSeguridadCommand addCoordenadaZonaSeguridadCommand;

    @Before
    public void setUp() {
        addCoordenadaZonaSeguridadCommand = Mockito.mock(AddCoordenadaZonaSeguridadCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(addCoordenadaZonaSeguridadCommand).execute();

        addCoordenadaZonaSeguridadCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(addCoordenadaZonaSeguridadCommand).execute();

        addCoordenadaZonaSeguridadCommand.execute();
    }
}