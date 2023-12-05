import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PuntoControlTest {

    private PuntoControl puntoControl;
    private Usuario usuarioMock;
    private Date date;

    @Before
    public void setUp() {
        usuarioMock = Mockito.mock(Usuario.class);
        date = new Date();
        puntoControl = new PuntoControl();
        puntoControl.setIdPos(1);
        puntoControl.setCoordenadaX(1.0f);
        puntoControl.setCoordenadaY(1.0f);
        puntoControl.setFechaHora(date);
        puntoControl.setUsuario(usuarioMock);
    }

    @Test
    public void testGetIdPos() {
        assertEquals(1, puntoControl.getIdPos());
    }

    @Test
    public void testSetIdPos() {
        puntoControl.setIdPos(2);
        assertEquals(2, puntoControl.getIdPos());
    }

    @Test
    public void testGetCoordenadaX() {
        assertEquals(1.0f, puntoControl.getCoordenadaX(), 0.01);
    }

    @Test
    public void testSetCoordenadaX() {
        puntoControl.setCoordenadaX(2.0f);
        assertEquals(2.0f, puntoControl.getCoordenadaX(), 0.01);
    }

    @Test
    public void testGetCoordenadaY() {
        assertEquals(1.0f, puntoControl.getCoordenadaY(), 0.01);
    }

    @Test
    public void testSetCoordenadaY() {
        puntoControl.setCoordenadaY(2.0f);
        assertEquals(2.0f, puntoControl.getCoordenadaY(), 0.01);
    }

    @Test
    public void testGetFechaHora() {
        assertEquals(date, puntoControl.getFechaHora());
    }

    @Test
    public void testSetFechaHora() {
        Date newDate = new Date();
        puntoControl.setFechaHora(newDate);
        assertEquals(newDate, puntoControl.getFechaHora());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuarioMock, puntoControl.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        Usuario newUsuarioMock = Mockito.mock(Usuario.class);
        puntoControl.setUsuario(newUsuarioMock);
        assertEquals(newUsuarioMock, puntoControl.getUsuario());
    }
}
