import com.ucab.cmcapp.implementation.UsuarioService;
import com.ucab.cmcapp.logic.commands.usuario.atomic.GetUsuarioByUsernameCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.CreateUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.DeleteUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.commands.usuario.composite.UpdateUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import com.ucab.cmcapp.logic.mappers.UsuarioMapperInsert;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {
    @Test
    public void testGetUsuarioById() {
        long userId = 1L;
        UsuarioDto expectedDto = new UsuarioDto();

        GetUsuarioCommand command = mock(GetUsuarioCommand.class);
        when(command.getReturnParam()).thenReturn(UsuarioMapper.mapDtoToEntity(userId));
        when(UsuarioMapper.mapEntityToDto(any())).thenReturn(expectedDto);

        UsuarioService service = new UsuarioService();
        UsuarioDto result = service.getUsuario(userId);

        verify(command).execute();
        verify(command).closeHandlerSession();
        verifyNoMoreInteractions(command);

        assertEquals(expectedDto, result);
    }

    @Test
    public void testGetUsuarioByUsername() {
        String username = "test";
        UsuarioDto expectedDto = new UsuarioDto();

        GetUsuarioByUsernameCommand command = mock(GetUsuarioByUsernameCommand.class);
        when(command.getReturnParam()).thenReturn(UsuarioMapper.mapDtoToEntityUsername(username));
        when(UsuarioMapper.mapEntityToDto(any())).thenReturn(expectedDto);

        UsuarioService service = new UsuarioService();
        UsuarioDto result = service.getUsuario(username);

        verify(command).execute();
        verify(command).closeHandlerSession();
        verifyNoMoreInteractions(command);

        assertEquals(expectedDto, result);
    }

    @Test
    public void testAddUsuario() throws ParseException {
        UsuarioDto userDto = new UsuarioDto();
        UsuarioDto expectedDto = new UsuarioDto();

        CreateUsuarioCommand command = mock(CreateUsuarioCommand.class);
        when(command.getReturnParam()).thenReturn(UsuarioMapperInsert.mapDtoToEntity(userDto));
        when(UsuarioMapperInsert.mapEntityToDto(any())).thenReturn(expectedDto);

        UsuarioService service = new UsuarioService();
        UsuarioDto result = service.addUsuario(userDto);

        verify(command).execute();
        verify(command).closeHandlerSession();
        verifyNoMoreInteractions(command);

        assertEquals(expectedDto, result);
    }

    @Test
    public void testDeleteUsuario() throws ParseException {
        UsuarioDto userDto = new UsuarioDto();
        UsuarioDto expectedDto = new UsuarioDto();

        DeleteUsuarioCommand command = mock(DeleteUsuarioCommand.class);
        when(command.getReturnParam()).thenReturn(UsuarioMapper.mapDtoToEntity(userDto));
        when(UsuarioMapper.mapEntityToDto(any())).thenReturn(expectedDto);

        UsuarioService service = new UsuarioService();
        UsuarioDto result = service.deleteUsuario(userDto);

        verify(command).execute();
        verify(command).closeHandlerSession();
        verifyNoMoreInteractions(command);

        assertEquals(expectedDto, result);
    }

    @Test
    public void testUpdateUsuario() throws ParseException {
        UsuarioDto userDto = new UsuarioDto();
        UsuarioDto expectedDto = new UsuarioDto();

        UpdateUsuarioCommand command = mock(UpdateUsuarioCommand.class);
        when(command.getReturnParam()).thenReturn(UsuarioMapper.mapDtoToEntity(userDto));
        when(UsuarioMapper.mapEntityToDto(any())).thenReturn(expectedDto);

        UsuarioService service = new UsuarioService();
        UsuarioDto result = service.updateUsuario(userDto);

        verify(command).execute();
        verify(command).closeHandlerSession();
        verifyNoMoreInteractions(command);

        assertEquals(expectedDto, result);
    }
}