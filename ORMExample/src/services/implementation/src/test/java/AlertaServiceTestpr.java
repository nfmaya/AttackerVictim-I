import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.implementation.AlertaService;
import com.ucab.cmcapp.logic.commands.alerta.composite.GetAlertaCommand;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlertaServiceTestpr {

    @Mock
    private AlertaMapper alertaMapper;

    @Mock
    private CommandFactory commandFactory;

    @Mock
    private GetAlertaCommand getAlertaCommand;

    private AlertaService alertaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        alertaService = new AlertaService();
    }

    /*@Test
    public void testGetAlertaSuccess() {
        long alertaId = 1L;
        Alerta alerta = new Alerta();
        AlertaDto alertaDto = new AlertaDto();

        when(AlertaMapper.mapDtoToEntity(alertaId)).thenReturn(new Alerta());
        when(CommandFactory.createGetAlertaCommand(alerta)).thenReturn(getAlertaCommand);
        when(getAlertaCommand.getReturnParam()).thenReturn(alerta);
        when(AlertaMapper.mapEntityToDto(alerta)).thenReturn(alertaDto);

        Response response = alertaService.getAlerta(alertaId);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetAlertaNoResult() {
        long alertaId = 2L;
        Alerta alerta = new Alerta();

        when(alertaMapper.mapDtoToEntity(alertaId)).thenReturn(new Alerta());
        when(commandFactory.createGetAlertaCommand(alerta)).thenReturn(getAlertaCommand);
        when(getAlertaCommand.getReturnParam()).thenReturn(null);

        Response response = alertaService.getAlerta(alertaId);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetAlertaException() {
        long alertaId = 3L;
        Alerta alerta = new Alerta();

        when(alertaMapper.mapDtoToEntity(alertaId)).thenReturn(new Alerta());
        when(commandFactory.createGetAlertaCommand(alerta)).thenReturn(getAlertaCommand);
        doThrow(new RuntimeException()).when(getAlertaCommand).execute();

        Response response = alertaService.getAlerta(alertaId);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }*/
}