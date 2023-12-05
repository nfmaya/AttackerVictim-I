import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class UsuarioTest {

    private Usuario usuario;
    private UserType userTypeMock;

    @Before
    public void setUp() {
        userTypeMock = Mockito.mock(UserType.class);
        usuario = new Usuario();
        usuario.set_idUsuario(1);
        usuario.set_Username("Test");
        usuario.set_Nombre("Test Name");
        usuario.setDocIdentidad("123456");
        usuario.setIMEI("123456789");
        usuario.setEstatus(true);
        usuario.set_userType(userTypeMock);
    }

    @Test
    public void testGetIdUsuario() {
        assertEquals(1, usuario.get_idUsuario());
    }

    @Test
    public void testSetIdUsuario() {
        usuario.set_idUsuario(2);
        assertEquals(2, usuario.get_idUsuario());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Test", usuario.get_Username());
    }

    @Test
    public void testSetUsername() {
        usuario.set_Username("New Test");
        assertEquals("New Test", usuario.get_Username());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Test Name", usuario.get_Nombre());
    }

    @Test
    public void testSetNombre() {
        usuario.set_Nombre("New Test Name");
        assertEquals("New Test Name", usuario.get_Nombre());
    }

    @Test
    public void testGetDocIdentidad() {
        assertEquals("123456", usuario.getDocIdentidad());
    }

    @Test
    public void testSetDocIdentidad() {
        usuario.setDocIdentidad("654321");
        assertEquals("654321", usuario.getDocIdentidad());
    }

    @Test
    public void testGetIMEI() {
        assertEquals("123456789", usuario.getIMEI());
    }

    @Test
    public void testSetIMEI() {
        usuario.setIMEI("987654321");
        assertEquals("987654321", usuario.getIMEI());
    }

    @Test
    public void testIsEstatus() {
        assertEquals(true, usuario.isEstatus());
    }

    @Test
    public void testSetEstatus() {
        usuario.setEstatus(false);
        assertEquals(false, usuario.isEstatus());
    }

    @Test
    public void testGetUserType() {
        assertEquals(userTypeMock, usuario.get_userType());
    }

    @Test
    public void testSetUserType() {
        UserType newUserTypeMock = Mockito.mock(UserType.class);
        usuario.set_userType(newUserTypeMock);
        assertEquals(newUserTypeMock, usuario.get_userType());
    }
}
