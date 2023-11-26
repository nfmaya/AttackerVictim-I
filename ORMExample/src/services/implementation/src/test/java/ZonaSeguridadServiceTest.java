import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.implementation.ZonaSeguridadService;
import com.ucab.cmcapp.logic.dtos.ZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.ZonaSeguridadMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ZonaSeguridadServiceTest {

    private ZonaSeguridadService ZonaSeguridadService;
    private ZonaSeguridadDto ZonaSeguridadDto;

    @Before
    public void setUp() {
        ZonaSeguridadService = Mockito.mock(ZonaSeguridadService.class);
        ZonaSeguridadDto = new ZonaSeguridadDto();
        ZonaSeguridadDto.setId(1L);
    }

    @Test
    public void getZonaSeguridadReturnsExpectedZonaSeguridadWhenZonaSeguridadExists() {
        when(ZonaSeguridadService.getZonaSeguridad(1L)).thenReturn(Response.status(Response.Status.OK).entity(ZonaSeguridadDto).build());

        Response actualZonaSeguridad = ZonaSeguridadService.getZonaSeguridad(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualZonaSeguridad.getStatus());
        assertEquals(ZonaSeguridadDto, actualZonaSeguridad.getEntity());
    }


    @Test
    public void getZonaSeguridadReturnsNotFoundWhenZonaSeguridadDoesNotExist() {
        when(ZonaSeguridadService.getZonaSeguridad(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualZonaSeguridad = ZonaSeguridadService.getZonaSeguridad(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualZonaSeguridad.getStatus());
    }

    @Test
    public void getZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(ZonaSeguridadService.getZonaSeguridad(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualZonaSeguridad = ZonaSeguridadService.getZonaSeguridad(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualZonaSeguridad.getStatus());
    }


    @Test
    public void addZonaSeguridadReturnsExpectedZonaSeguridadWhenZonaSeguridadIsAdded() {
        when(ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.OK).entity(ZonaSeguridadDto).build());

        Response actualZonaSeguridad = ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualZonaSeguridad.getStatus());
        assertEquals(ZonaSeguridadDto, actualZonaSeguridad.getEntity());
    }

    @Test
    public void addZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualZonaSeguridad = ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualZonaSeguridad.getStatus());
    }

    @Test
    public void addZonaSeguridadReturnsNotFoundWhenZonaSeguridadCannotBeAdded() {
        when(ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualZonaSeguridad = ZonaSeguridadService.addZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualZonaSeguridad.getStatus());
    }



    @Test
    public void updateZonaSeguridadReturnsExpectedZonaSeguridadWhenZonaSeguridadIsUpdated() {
        when(ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.OK).entity(ZonaSeguridadDto).build());

        Response actualZonaSeguridad = ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualZonaSeguridad.getStatus());
        assertEquals(ZonaSeguridadDto, actualZonaSeguridad.getEntity());
    }

    @Test
    public void updateZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualZonaSeguridad = ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualZonaSeguridad.getStatus());
    }

    @Test
    public void updateZonaSeguridadReturnsNotFoundWhenZonaSeguridadCannotBeUpdated() {
        when(ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualZonaSeguridad = ZonaSeguridadService.updateZonaSeguridad(ZonaSeguridadDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualZonaSeguridad.getStatus());
    }
}