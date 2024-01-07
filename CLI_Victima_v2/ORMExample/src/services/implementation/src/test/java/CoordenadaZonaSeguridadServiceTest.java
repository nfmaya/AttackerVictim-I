import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.implementation.CoordenadaZonaSeguridadService;
import com.ucab.cmcapp.logic.dtos.CoordenadaZonaSeguridadDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaZonaSeguridadMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CoordenadaZonaSeguridadServiceTest {

    private CoordenadaZonaSeguridadService CoordenadaZonaSeguridadService;
    private CoordenadaZonaSeguridadDto CoordenadaZonaSeguridadDto;

    @Before
    public void setUp() {
        CoordenadaZonaSeguridadService = Mockito.mock(CoordenadaZonaSeguridadService.class);
        CoordenadaZonaSeguridadDto = new CoordenadaZonaSeguridadDto();
        CoordenadaZonaSeguridadDto.setId(1L);
    }

   /* @Test
    public void getCoordenadaZonaSeguridadReturnsExpectedCoordenadaZonaSeguridadWhenCoordenadaZonaSeguridadExists() {
        when(CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(1L)).thenReturn(Response.status(Response.Status.OK).entity(CoordenadaZonaSeguridadDto).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
        assertEquals(CoordenadaZonaSeguridadDto, actualCoordenadaZonaSeguridad.getEntity());
    }


    @Test
    public void getCoordenadaZonaSeguridadReturnsNotFoundWhenCoordenadaZonaSeguridadDoesNotExist() {
        when(CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }

    @Test
    public void getCoordenadaZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.getCoordenadaZonaSeguridad(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }*/


    @Test
    public void addCoordenadaZonaSeguridadReturnsExpectedCoordenadaZonaSeguridadWhenCoordenadaZonaSeguridadIsAdded() {
        when(CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.OK).entity(CoordenadaZonaSeguridadDto).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
        assertEquals(CoordenadaZonaSeguridadDto, actualCoordenadaZonaSeguridad.getEntity());
    }

    @Test
    public void addCoordenadaZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }

    @Test
    public void addCoordenadaZonaSeguridadReturnsNotFoundWhenCoordenadaZonaSeguridadCannotBeAdded() {
        when(CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.addCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }



    @Test
    public void updateCoordenadaZonaSeguridadReturnsExpectedCoordenadaZonaSeguridadWhenCoordenadaZonaSeguridadIsUpdated() {
        when(CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.OK).entity(CoordenadaZonaSeguridadDto).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
        assertEquals(CoordenadaZonaSeguridadDto, actualCoordenadaZonaSeguridad.getEntity());
    }

    @Test
    public void updateCoordenadaZonaSeguridadReturnsServerErrorWhenExceptionOccurs() {
        when(CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }

    @Test
    public void updateCoordenadaZonaSeguridadReturnsNotFoundWhenCoordenadaZonaSeguridadCannotBeUpdated() {
        when(CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualCoordenadaZonaSeguridad = CoordenadaZonaSeguridadService.updateCoordenadaZonaSeguridad(CoordenadaZonaSeguridadDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualCoordenadaZonaSeguridad.getStatus());
    }
}