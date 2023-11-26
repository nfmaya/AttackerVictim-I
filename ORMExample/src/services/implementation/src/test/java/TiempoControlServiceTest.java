import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.implementation.TiempoControlService;
import com.ucab.cmcapp.logic.dtos.TiempoControlDto;
import com.ucab.cmcapp.logic.mappers.TiempoControlMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TiempoControlServiceTest {

    private TiempoControlService TiempoControlService;
    private TiempoControlDto TiempoControlDto;

    @Before
    public void setUp() {
        TiempoControlService = Mockito.mock(TiempoControlService.class);
        TiempoControlDto = new TiempoControlDto();
        TiempoControlDto.setId(1L);
    }

    @Test
    public void getTiempoControlReturnsExpectedTiempoControlWhenTiempoControlExists() {
        when(TiempoControlService.getTiempoControl(1L)).thenReturn(Response.status(Response.Status.OK).entity(TiempoControlDto).build());

        Response actualTiempoControl = TiempoControlService.getTiempoControl(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualTiempoControl.getStatus());
        assertEquals(TiempoControlDto, actualTiempoControl.getEntity());
    }


    @Test
    public void getTiempoControlReturnsNotFoundWhenTiempoControlDoesNotExist() {
        when(TiempoControlService.getTiempoControl(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualTiempoControl = TiempoControlService.getTiempoControl(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualTiempoControl.getStatus());
    }

    @Test
    public void getTiempoControlReturnsServerErrorWhenExceptionOccurs() {
        when(TiempoControlService.getTiempoControl(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualTiempoControl = TiempoControlService.getTiempoControl(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualTiempoControl.getStatus());
    }


    @Test
    public void addTiempoControlReturnsExpectedTiempoControlWhenTiempoControlIsAdded() {
        when(TiempoControlService.addTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.OK).entity(TiempoControlDto).build());

        Response actualTiempoControl = TiempoControlService.addTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualTiempoControl.getStatus());
        assertEquals(TiempoControlDto, actualTiempoControl.getEntity());
    }

    @Test
    public void addTiempoControlReturnsServerErrorWhenExceptionOccurs() {
        when(TiempoControlService.addTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualTiempoControl = TiempoControlService.addTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualTiempoControl.getStatus());
    }

    @Test
    public void addTiempoControlReturnsNotFoundWhenTiempoControlCannotBeAdded() {
        when(TiempoControlService.addTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualTiempoControl = TiempoControlService.addTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualTiempoControl.getStatus());
    }



    @Test
    public void updateTiempoControlReturnsExpectedTiempoControlWhenTiempoControlIsUpdated() {
        when(TiempoControlService.updateTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.OK).entity(TiempoControlDto).build());

        Response actualTiempoControl = TiempoControlService.updateTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualTiempoControl.getStatus());
        assertEquals(TiempoControlDto, actualTiempoControl.getEntity());
    }

    @Test
    public void updateTiempoControlReturnsServerErrorWhenExceptionOccurs() {
        when(TiempoControlService.updateTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualTiempoControl = TiempoControlService.updateTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualTiempoControl.getStatus());
    }

    @Test
    public void updateTiempoControlReturnsNotFoundWhenTiempoControlCannotBeUpdated() {
        when(TiempoControlService.updateTiempoControl(TiempoControlDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualTiempoControl = TiempoControlService.updateTiempoControl(TiempoControlDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualTiempoControl.getStatus());
    }
}