import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.implementation.AlertaService;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AlertaServiceTest {

    private AlertaService alertaService;
    private AlertaDto alertaDto;

    @Before
    public void setUp() {
        alertaService = Mockito.mock(AlertaService.class);
        alertaDto = new AlertaDto();
        alertaDto.setId(1L);
    }

    @Test
    public void getAlertaReturnsExpectedAlertaWhenAlertaExists() {
        when(alertaService.getAlerta(1L)).thenReturn(Response.status(Response.Status.OK).entity(alertaDto).build());

        Response actualAlerta = alertaService.getAlerta(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualAlerta.getStatus());
        assertEquals(alertaDto, actualAlerta.getEntity());
    }


    @Test
    public void getAlertaReturnsNotFoundWhenAlertaDoesNotExist() {
        when(alertaService.getAlerta(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualAlerta = alertaService.getAlerta(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void getAlertaReturnsServerErrorWhenExceptionOccurs() {
        when(alertaService.getAlerta(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualAlerta = alertaService.getAlerta(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualAlerta.getStatus());
    }


    @Test
    public void addAlertaReturnsExpectedAlertaWhenAlertaIsAdded() {
        when(alertaService.addAlerta(alertaDto)).thenReturn(Response.status(Response.Status.OK).entity(alertaDto).build());

        Response actualAlerta = alertaService.addAlerta(alertaDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualAlerta.getStatus());
        assertEquals(alertaDto, actualAlerta.getEntity());
    }

    @Test
    public void addAlertaReturnsServerErrorWhenExceptionOccurs() {
        when(alertaService.addAlerta(alertaDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualAlerta = alertaService.addAlerta(alertaDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void addAlertaReturnsNotFoundWhenAlertaCannotBeAdded() {
        when(alertaService.addAlerta(alertaDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualAlerta = alertaService.addAlerta(alertaDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualAlerta.getStatus());
    }



    @Test
    public void updateAlertaReturnsExpectedAlertaWhenAlertaIsUpdated() {
        when(alertaService.updateAlerta(alertaDto)).thenReturn(Response.status(Response.Status.OK).entity(alertaDto).build());

        Response actualAlerta = alertaService.updateAlerta(alertaDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualAlerta.getStatus());
        assertEquals(alertaDto, actualAlerta.getEntity());
    }

    @Test
    public void updateAlertaReturnsServerErrorWhenExceptionOccurs() {
        when(alertaService.updateAlerta(alertaDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualAlerta = alertaService.updateAlerta(alertaDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void updateAlertaReturnsNotFoundWhenAlertaCannotBeUpdated() {
        when(alertaService.updateAlerta(alertaDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualAlerta = alertaService.updateAlerta(alertaDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void deleteAlertaReturnsExpectedAlertaWhenAlertaIsDeleted() {
        when(alertaService.deleteAlerta(alertaDto)).thenReturn(Response.status(Response.Status.OK).entity(alertaDto).build());

        Response actualAlerta = alertaService.deleteAlerta(alertaDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualAlerta.getStatus());
        assertEquals(alertaDto, actualAlerta.getEntity());
    }

    @Test
    public void deleteAlertaReturnsServerErrorWhenExceptionOccurs() {
        when(alertaService.deleteAlerta(alertaDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualAlerta = alertaService.deleteAlerta(alertaDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void deleteAlertaReturnsNotFoundWhenAlertaCannotBeDeleted() {
        when(alertaService.deleteAlerta(alertaDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualAlerta = alertaService.deleteAlerta(alertaDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void deleteAlerta2ReturnsExpectedAlertaWhenAlertaIsDeleted() {
        when(alertaService.deleteAlerta2(alertaDto)).thenReturn(Response.status(Response.Status.OK).entity(alertaDto).build());

        Response actualAlerta = alertaService.deleteAlerta2(alertaDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualAlerta.getStatus());
        assertEquals(alertaDto, actualAlerta.getEntity());
    }

    @Test
    public void deleteAlerta2ReturnsServerErrorWhenExceptionOccurs() {
        when(alertaService.deleteAlerta2(alertaDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualAlerta = alertaService.deleteAlerta2(alertaDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualAlerta.getStatus());
    }

    @Test
    public void deleteAlerta2ReturnsNotFoundWhenAlertaCannotBeDeleted() {
        when(alertaService.deleteAlerta2(alertaDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualAlerta = alertaService.deleteAlerta2(alertaDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualAlerta.getStatus());
    }


}