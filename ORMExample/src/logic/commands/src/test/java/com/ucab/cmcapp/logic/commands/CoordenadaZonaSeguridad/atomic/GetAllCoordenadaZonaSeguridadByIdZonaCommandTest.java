package com.ucab.cmcapp.logic.commands.CoordenadaZonaSeguridad.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class GetAllCoordenadaZonaSeguridadByIdZonaCommandTest {

    private GetAllCoordenadaZonaSeguridadByIdZonaCommand getAllCoordenadaZonaSeguridadByIdZonaCommand;

    @Before
    public void setUp() {
        getAllCoordenadaZonaSeguridadByIdZonaCommand = Mockito.mock(GetAllCoordenadaZonaSeguridadByIdZonaCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(getAllCoordenadaZonaSeguridadByIdZonaCommand).execute();

        getAllCoordenadaZonaSeguridadByIdZonaCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(getAllCoordenadaZonaSeguridadByIdZonaCommand).execute();

        getAllCoordenadaZonaSeguridadByIdZonaCommand.execute();
    }
}