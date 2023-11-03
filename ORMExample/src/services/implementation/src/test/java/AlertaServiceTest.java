import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.implementation.AlertaService;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AlertaServiceTest {
    @Test
    public void testGetAlerta() {
        long alertaId = 1L;
        Alerta alerta = new Alerta();
        AlertaDto expectedDto = new AlertaDto();

        // Create mock objects
        GetAlertaCommand getAlertaCommand = mock(GetAlertaCommand.class);
        AlertaService alertaService = new AlertaService();

        // Stub method calls using Mockito.when()
        when(getAlertaCommand.getReturnParam()).thenReturn(alerta);
        when(AlertaMapper.mapEntityToDto(any(Alerta.class))).thenReturn(expectedDto);

        AlertaDto result = alertaService.getAlerta(alertaId);

        // Verify method invocations
        verify(getAlertaCommand).execute();
        verify(getAlertaCommand).closeHandlerSession();
        verifyNoMoreInteractions(getAlertaCommand);

        // Assertions
        assertEquals(expectedDto, result);
    }
}
