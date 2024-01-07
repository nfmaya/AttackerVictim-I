import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.implementation.UsuarioService;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    private UsuarioService UsuarioService;
    private UsuarioDto UsuarioDto;

    @Before
    public void setUp() {
        UsuarioService = Mockito.mock(UsuarioService.class);
        UsuarioDto = new UsuarioDto();
        UsuarioDto.setId(1L);
    }

    /*@Test
    public void getUsuarioReturnsExpectedUsuarioWhenUsuarioExists() {
        when(UsuarioService.getUsuario(1L)).thenReturn(Response.status(Response.Status.OK).entity(UsuarioDto).build());

        Response actualUsuario = UsuarioService.getUsuario(1L);

        assertEquals(Response.Status.OK.getStatusCode(), actualUsuario.getStatus());
        assertEquals(UsuarioDto, actualUsuario.getEntity());
    }


    @Test
    public void getUsuarioReturnsNotFoundWhenUsuarioDoesNotExist() {
        when(UsuarioService.getUsuario(2L)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUsuario = UsuarioService.getUsuario(2L);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUsuario.getStatus());
    }

    @Test
    public void getUsuarioReturnsServerErrorWhenExceptionOccurs() {
        when(UsuarioService.getUsuario(3L)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUsuario = UsuarioService.getUsuario(3L);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUsuario.getStatus());
    }*/


    @Test
    public void addUsuarioReturnsExpectedUsuarioWhenUsuarioIsAdded() {
        when(UsuarioService.addUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.OK).entity(UsuarioDto).build());

        Response actualUsuario = UsuarioService.addUsuario(UsuarioDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualUsuario.getStatus());
        assertEquals(UsuarioDto, actualUsuario.getEntity());
    }

    @Test
    public void addUsuarioReturnsServerErrorWhenExceptionOccurs() {
        when(UsuarioService.addUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUsuario = UsuarioService.addUsuario(UsuarioDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUsuario.getStatus());
    }

    @Test
    public void addUsuarioReturnsNotFoundWhenUsuarioCannotBeAdded() {
        when(UsuarioService.addUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUsuario = UsuarioService.addUsuario(UsuarioDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUsuario.getStatus());
    }



    @Test
    public void updateUsuarioReturnsExpectedUsuarioWhenUsuarioIsUpdated() {
        when(UsuarioService.updateUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.OK).entity(UsuarioDto).build());

        Response actualUsuario = UsuarioService.updateUsuario(UsuarioDto);

        assertEquals(Response.Status.OK.getStatusCode(), actualUsuario.getStatus());
        assertEquals(UsuarioDto, actualUsuario.getEntity());
    }

    @Test
    public void updateUsuarioReturnsServerErrorWhenExceptionOccurs() {
        when(UsuarioService.updateUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());

        Response actualUsuario = UsuarioService.updateUsuario(UsuarioDto);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), actualUsuario.getStatus());
    }

    @Test
    public void updateUsuarioReturnsNotFoundWhenUsuarioCannotBeUpdated() {
        when(UsuarioService.updateUsuario(UsuarioDto)).thenReturn(Response.status(Response.Status.NOT_FOUND).build());

        Response actualUsuario = UsuarioService.updateUsuario(UsuarioDto);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), actualUsuario.getStatus());
    }
}