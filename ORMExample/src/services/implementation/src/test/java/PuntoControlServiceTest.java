import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.implementation.PuntoControlService;
import com.ucab.cmcapp.logic.dtos.PuntoControlDto;
import com.ucab.cmcapp.logic.mappers.PuntoControlMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PuntoControlServiceTest {

    private PuntoControlService PuntoControlService;
    private PuntoControlDto PuntoControlDto;

    @Before
    public void setUp() {
        PuntoControlService = Mockito.mock(PuntoControlService.class);
        PuntoControlDto = new PuntoControlDto();
        PuntoControlDto.setId(1L);
    }

    @Test
    public void getPuntoControlReturnsExpectedPuntoControlWhenPuntoControlExists() {
        when(PuntoControlService.getPuntoControl(1L)).thenReturn(Response.status(Response.Status.OK).entity(PuntoControlDto).build());

        Response actualPuntoControl = PuntoControlService.getPuntoControl(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualPuntoControl.getStatus());
        assertEquals(PuntoControlDto, actualPuntoControl.getEntity());
    }


    @Test
    public void getPuntoControlReturnsNotFoundWhenPuntoControlDoesNotExist() {
        when(PuntoControlService.getPuntoControl(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPuntoControl = PuntoControlService.getPuntoControl(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPuntoControl.getStatus());
    }

    @Test
    public void getPuntoControlReturnsServerErrorWhenExceptionOccurs() {
        when(PuntoControlService.getPuntoControl(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPuntoControl = PuntoControlService.getPuntoControl(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPuntoControl.getStatus());
    }


    @Test
    public void addPuntoControlReturnsExpectedPuntoControlWhenPuntoControlIsAdded() {
        when(PuntoControlService.addPuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.OK).entity(PuntoControlDto).build());

        Response actualPuntoControl = PuntoControlService.addPuntoControl(PuntoControlDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualPuntoControl.getStatus());
        assertEquals(PuntoControlDto, actualPuntoControl.getEntity());
    }

    @Test
    public void addPuntoControlReturnsServerErrorWhenExceptionOccurs() {
        when(PuntoControlService.addPuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPuntoControl = PuntoControlService.addPuntoControl(PuntoControlDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPuntoControl.getStatus());
    }

    @Test
    public void addPuntoControlReturnsNotFoundWhenPuntoControlCannotBeAdded() {
        when(PuntoControlService.addPuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPuntoControl = PuntoControlService.addPuntoControl(PuntoControlDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPuntoControl.getStatus());
    }



    @Test
    public void updatePuntoControlReturnsExpectedPuntoControlWhenPuntoControlIsUpdated() {
        when(PuntoControlService.updatePuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.OK).entity(PuntoControlDto).build());

        Response actualPuntoControl = PuntoControlService.updatePuntoControl(PuntoControlDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualPuntoControl.getStatus());
        assertEquals(PuntoControlDto, actualPuntoControl.getEntity());
    }

    @Test
    public void updatePuntoControlReturnsServerErrorWhenExceptionOccurs() {
        when(PuntoControlService.updatePuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPuntoControl = PuntoControlService.updatePuntoControl(PuntoControlDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPuntoControl.getStatus());
    }

    @Test
    public void updatePuntoControlReturnsNotFoundWhenPuntoControlCannotBeUpdated() {
        when(PuntoControlService.updatePuntoControl(PuntoControlDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPuntoControl = PuntoControlService.updatePuntoControl(PuntoControlDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPuntoControl.getStatus());
    }
}