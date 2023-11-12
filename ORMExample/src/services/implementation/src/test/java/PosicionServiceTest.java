
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.implementation.PosicionService;
import com.ucab.cmcapp.logic.commands.posicion.composite.*;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import com.ucab.cmcapp.logic.mappers.PosicionMapperInsert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PosicionServiceTest {
    /*
@Test
public void testGetPosicion() {

    long posicionId = 1L;
    Posicion posicion = new Posicion();
    PosicionDto expectedDto = new PosicionDto();

    // Create mock objects
    GetPosicionCommand getPosicionCommand = mock(GetPosicionCommand.class);
    PosicionService posicionService = new PosicionService();

    // Stub method calls using Mockito.when()
    when(getPosicionCommand.getReturnParam()).thenReturn(posicion);
    when(PosicionMapper.mapEntityToDto(any(Posicion.class))).thenReturn(expectedDto);

    // Call the method under test
    PosicionDto result = null;
    try {
        result = posicionService.getPosicion(posicionId);
    } catch (NullPointerException e) {
        fail("NullPointerException thrown: " + e.getMessage());
    }

    // Verify method invocations
    verify(getPosicionCommand).execute();
    verify(getPosicionCommand).closeHandlerSession();
    verifyNoMoreInteractions(getPosicionCommand);

    // Assertions
    assertEquals(expectedDto, result);
}

    @Test
    public void testAddPosicion() {
        PosicionDto inputDto = new PosicionDto();
        Posicion posicion = new Posicion();
        PosicionDto expectedDto = new PosicionDto();

        // Create mock objects
        CreatePosicionCommand createPosicionCommand = mock(CreatePosicionCommand.class);
        PosicionService posicionService = new PosicionService();

        // Stub method calls using Mockito.when()
        when(createPosicionCommand.getReturnParam()).thenReturn(posicion);
        when(PosicionMapperInsert.mapEntityToDto(any(Posicion.class))).thenReturn(expectedDto);

        PosicionDto result = posicionService.addPosicion(inputDto);

        // Verify method invocations
        verify(createPosicionCommand).execute();
        verify(createPosicionCommand).closeHandlerSession();
        verifyNoMoreInteractions(createPosicionCommand);

        // Assertions
        assertEquals(expectedDto, result);
    }

    @Test
    public void testDeletePosicion() {
        PosicionDto inputDto = new PosicionDto();
        Posicion posicion = new Posicion();
        PosicionDto expectedDto = new PosicionDto();

        // Create mock objects
        DeletePosicionCommand deletePosicionCommand = mock(DeletePosicionCommand.class);
        PosicionService posicionService = new PosicionService();

        // Stub method calls using Mockito.when()
        when(deletePosicionCommand.getReturnParam()).thenReturn(posicion);
        when(PosicionMapper.mapEntityToDto(any(Posicion.class))).thenReturn(expectedDto);

        PosicionDto result = posicionService.deletePosicion(inputDto);

        // Verify method invocations
        verify(deletePosicionCommand).execute();
        verify(deletePosicionCommand).closeHandlerSession();
        verifyNoMoreInteractions(deletePosicionCommand);

        // Assertions
        assertEquals(expectedDto, result);
    }

    @Test
    public void testUpdatePosicion() {
        PosicionDto inputDto = new PosicionDto();
        Posicion posicion = new Posicion();
        PosicionDto expectedDto = new PosicionDto();

        // Create mock objects
        UpdatePosicionCommand updatePosicionCommand = mock(UpdatePosicionCommand.class);
        PosicionService posicionService = new PosicionService();

        // Stub method calls using Mockito.when()
        when(updatePosicionCommand.getReturnParam()).thenReturn(posicion);
        when(PosicionMapper.mapEntityToDto(any(Posicion.class))).thenReturn(expectedDto);

        PosicionDto result = posicionService.updatePosicion(inputDto);

        // Verify method invocations
        verify(updatePosicionCommand).execute();
        verify(updatePosicionCommand).closeHandlerSession();
        verifyNoMoreInteractions(updatePosicionCommand);

        // Assertions
        assertEquals(expectedDto, result);
    }

     */
}