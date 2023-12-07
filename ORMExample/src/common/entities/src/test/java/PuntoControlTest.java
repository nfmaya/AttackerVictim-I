import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void testDefaultConstructor() {
        PuntoControl defaultPuntoControl = new PuntoControl();
        assertEquals(0.0, defaultPuntoControl.getCoordenadaX(), 0.001);
        assertEquals(0.0, defaultPuntoControl.getCoordenadaY(), 0.001);
        assertNull(defaultPuntoControl.getFechaHora());
        assertNull(defaultPuntoControl.getUsuario());
    }

    @Test
    public void testCopyConstructor() {
        PuntoControl copy = new PuntoControl(puntoControl);
        assertEquals(puntoControl.getCoordenadaX(), copy.getCoordenadaX(), 0.001);
        assertEquals(puntoControl.getCoordenadaY(), copy.getCoordenadaY(), 0.001);
        assertEquals(puntoControl.getFechaHora(), copy.getFechaHora());
        assertEquals(puntoControl.getUsuario(), copy.getUsuario());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        PuntoControl idPuntoControl = new PuntoControl(id);
        assertEquals(id, idPuntoControl.getIdPos());
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
