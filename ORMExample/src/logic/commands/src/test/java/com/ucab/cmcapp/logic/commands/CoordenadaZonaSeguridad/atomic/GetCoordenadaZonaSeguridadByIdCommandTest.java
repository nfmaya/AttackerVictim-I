package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class GetCoordenadaZonaSeguridadByIdCommandTest {

    private GetCoordenadaZonaSeguridadByIdCommand getCoordenadaZonaSeguridadByIdCommand;

    @Before
    public void setUp() {
        getCoordenadaZonaSeguridadByIdCommand = Mockito.mock(GetCoordenadaZonaSeguridadByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(getCoordenadaZonaSeguridadByIdCommand).execute();

        getCoordenadaZonaSeguridadByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(getCoordenadaZonaSeguridadByIdCommand).execute();

        getCoordenadaZonaSeguridadByIdCommand.execute();
    }
}