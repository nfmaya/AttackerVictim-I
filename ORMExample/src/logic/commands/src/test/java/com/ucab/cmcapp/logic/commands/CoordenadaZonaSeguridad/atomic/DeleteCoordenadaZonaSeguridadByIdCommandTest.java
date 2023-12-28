package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DeleteCoordenadaZonaSeguridadByIdCommandTest {

    private DeleteCoordenadaZonaSeguridadByIdCommand deleteCoordenadaZonaSeguridadByIdCommand;

    @Before
    public void setUp() {
        deleteCoordenadaZonaSeguridadByIdCommand = Mockito.mock(DeleteCoordenadaZonaSeguridadByIdCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(deleteCoordenadaZonaSeguridadByIdCommand).execute();

        deleteCoordenadaZonaSeguridadByIdCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(deleteCoordenadaZonaSeguridadByIdCommand).execute();

        deleteCoordenadaZonaSeguridadByIdCommand.execute();
    }
}