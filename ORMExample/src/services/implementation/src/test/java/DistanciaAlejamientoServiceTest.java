import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.implementation.DistanciaAlejamientoService;
import com.ucab.cmcapp.logic.dtos.DistanciaAlejamientoDto;
import com.ucab.cmcapp.logic.mappers.DistanciaAlejamientoMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DistanciaAlejamientoServiceTest {

    private DistanciaAlejamientoService DistanciaAlejamientoService;
    private DistanciaAlejamientoDto DistanciaAlejamientoDto;

    @Before
    public void setUp() {
        DistanciaAlejamientoService = Mockito.mock(DistanciaAlejamientoService.class);
        DistanciaAlejamientoDto = new DistanciaAlejamientoDto();
        DistanciaAlejamientoDto.setId(1L);
    }

    /*@Test
    public void getDistanciaAlejamientoReturnsExpectedDistanciaAlejamientoWhenDistanciaAlejamientoExists() {
        when(DistanciaAlejamientoService.getDistanciaAlejamiento(1L)).thenReturn(Response.status(Response.Status.OK).entity(DistanciaAlejamientoDto).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.getDistanciaAlejamiento(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualDistanciaAlejamiento.getStatus());
        assertEquals(DistanciaAlejamientoDto, actualDistanciaAlejamiento.getEntity());
    }


    @Test
    public void getDistanciaAlejamientoReturnsNotFoundWhenDistanciaAlejamientoDoesNotExist() {
        when(DistanciaAlejamientoService.getDistanciaAlejamiento(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.getDistanciaAlejamiento(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }

    @Test
    public void getDistanciaAlejamientoReturnsServerErrorWhenExceptionOccurs() {
        when(DistanciaAlejamientoService.getDistanciaAlejamiento(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.getDistanciaAlejamiento(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }*/


    @Test
    public void addDistanciaAlejamientoReturnsExpectedDistanciaAlejamientoWhenDistanciaAlejamientoIsAdded() {
        when(DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.OK).entity(DistanciaAlejamientoDto).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualDistanciaAlejamiento.getStatus());
        assertEquals(DistanciaAlejamientoDto, actualDistanciaAlejamiento.getEntity());
    }

    @Test
    public void addDistanciaAlejamientoReturnsServerErrorWhenExceptionOccurs() {
        when(DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }

    @Test
    public void addDistanciaAlejamientoReturnsNotFoundWhenDistanciaAlejamientoCannotBeAdded() {
        when(DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.addDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }



    @Test
    public void updateDistanciaAlejamientoReturnsExpectedDistanciaAlejamientoWhenDistanciaAlejamientoIsUpdated() {
        when(DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.OK).entity(DistanciaAlejamientoDto).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualDistanciaAlejamiento.getStatus());
        assertEquals(DistanciaAlejamientoDto, actualDistanciaAlejamiento.getEntity());
    }

    @Test
    public void updateDistanciaAlejamientoReturnsServerErrorWhenExceptionOccurs() {
        when(DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }

    @Test
    public void updateDistanciaAlejamientoReturnsNotFoundWhenDistanciaAlejamientoCannotBeUpdated() {
        when(DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualDistanciaAlejamiento = DistanciaAlejamientoService.updateDistanciaAlejamiento(DistanciaAlejamientoDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualDistanciaAlejamiento.getStatus());
    }
}