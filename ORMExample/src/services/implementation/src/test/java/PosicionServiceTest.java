import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.implementation.PosicionService;
import com.ucab.cmcapp.logic.dtos.PosicionDto;
import com.ucab.cmcapp.logic.mappers.PosicionMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PosicionServiceTest {

    private PosicionService PosicionService;
    private PosicionDto PosicionDto;

    @Before
    public void setUp() {
        PosicionService = Mockito.mock(PosicionService.class);
        PosicionDto = new PosicionDto();
        PosicionDto.setId(1L);
    }

    @Test
    public void getPosicionReturnsExpectedPosicionWhenPosicionExists() {
        when(PosicionService.getPosicion(1L)).thenReturn(Response.status(Response.Status.OK).entity(PosicionDto).build());

        Response actualPosicion = PosicionService.getPosicion(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualPosicion.getStatus());
        assertEquals(PosicionDto, actualPosicion.getEntity());
    }


    @Test
    public void getPosicionReturnsNotFoundWhenPosicionDoesNotExist() {
        when(PosicionService.getPosicion(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPosicion = PosicionService.getPosicion(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPosicion.getStatus());
    }

    @Test
    public void getPosicionReturnsServerErrorWhenExceptionOccurs() {
        when(PosicionService.getPosicion(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPosicion = PosicionService.getPosicion(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPosicion.getStatus());
    }


    @Test
    public void addPosicionReturnsExpectedPosicionWhenPosicionIsAdded() {
        when(PosicionService.addPosicion(PosicionDto)).thenReturn(Response.status(Response.Status.OK).entity(PosicionDto).build());

        Response actualPosicion = PosicionService.addPosicion(PosicionDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualPosicion.getStatus());
        assertEquals(PosicionDto, actualPosicion.getEntity());
    }

    @Test
    public void addPosicionReturnsServerErrorWhenExceptionOccurs() {
        when(PosicionService.addPosicion(PosicionDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPosicion = PosicionService.addPosicion(PosicionDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPosicion.getStatus());
    }

    @Test
    public void addPosicionReturnsNotFoundWhenPosicionCannotBeAdded() {
        when(PosicionService.addPosicion(PosicionDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPosicion = PosicionService.addPosicion(PosicionDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPosicion.getStatus());
    }



    @Test
    public void updatePosicionReturnsExpectedPosicionWhenPosicionIsUpdated() {
        when(PosicionService.updatePosicion(PosicionDto)).thenReturn(Response.status(Response.Status.OK).entity(PosicionDto).build());

        Response actualPosicion = PosicionService.updatePosicion(PosicionDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualPosicion.getStatus());
        assertEquals(PosicionDto, actualPosicion.getEntity());
    }

    @Test
    public void updatePosicionReturnsServerErrorWhenExceptionOccurs() {
        when(PosicionService.updatePosicion(PosicionDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualPosicion = PosicionService.updatePosicion(PosicionDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualPosicion.getStatus());
    }

    @Test
    public void updatePosicionReturnsNotFoundWhenPosicionCannotBeUpdated() {
        when(PosicionService.updatePosicion(PosicionDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualPosicion = PosicionService.updatePosicion(PosicionDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualPosicion.getStatus());
    }
}