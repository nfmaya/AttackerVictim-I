package com.ucab.cmcapp.logic.commands.DistanciaAlejamiento.atomic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class AddDistanciaAlejamientoCommandTest {

    private AddDistanciaAlejamientoCommand addDistanciaAlejamientoCommand;

    @Before
    public void setUp() {
        addDistanciaAlejamientoCommand = Mockito.mock(AddDistanciaAlejamientoCommand.class);
    }

    @Test
    public void executeRunsSuccessfully() {
        doNothing().when(addDistanciaAlejamientoCommand).execute();

        addDistanciaAlejamientoCommand.execute();
    }

    @Test(expected = Exception.class)
    public void executeThrowsExceptionWhenErrorOccurs() {
        doThrow(new Exception()).when(addDistanciaAlejamientoCommand).execute();

        addDistanciaAlejamientoCommand.execute();
    }
}