import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AlertaTest {

    private Alerta alerta;
    private Usuario usuarioMock;
    private Date date;

    @Before
    public void setUp() {
        usuarioMock = Mockito.mock(Usuario.class);
        date = new Date();
        alerta = new Alerta();
        alerta.set_IdAlerta(1);
        alerta.set_tipoAlerta("Test");
        alerta.set_fechaHora(date);
        alerta.setUsuario(usuarioMock);
    }

    @Test
    public void testGetIdAlerta() {
        assertEquals(1, alerta.get_IdAlerta());
    }

    @Test
    public void testSetIdAlerta() {
        alerta.set_IdAlerta(2);
        assertEquals(2, alerta.get_IdAlerta());
    }

    @Test
    public void testGetTipoAlerta() {
        assertEquals("Test", alerta.get_tipoAlerta());
    }

    @Test
    public void testSetTipoAlerta() {
        alerta.set_tipoAlerta("New Test");
        assertEquals("New Test", alerta.get_tipoAlerta());
    }

    @Test
    public void testGetFechaHora() {
        assertEquals(date, alerta.get_fechaHora());
    }

    @Test
    public void testSetFechaHora() {
        Date newDate = new Date();
        alerta.set_fechaHora(newDate);
        assertEquals(newDate, alerta.get_fechaHora());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuarioMock, alerta.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        Usuario newUsuarioMock = Mockito.mock(Usuario.class);
        alerta.setUsuario(newUsuarioMock);
        assertEquals(newUsuarioMock, alerta.getUsuario());
    }
}
