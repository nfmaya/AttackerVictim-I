import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.Posicion;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PosicionTest {

    private Posicion posicion;
    private Usuario usuarioMock;
    private Date date;

    @Before
    public void setUp() {
        usuarioMock = Mockito.mock(Usuario.class);
        date = new Date();
        posicion = new Posicion();
        posicion.setIdPos(1);
        posicion.setCoordenadaX(1.0f);
        posicion.setCoordenadaY(1.0f);
        posicion.setFechaHora(date);
        posicion.setUsuario(usuarioMock);
    }

    @Test
    public void testGetIdPos() {
        assertEquals(1, posicion.getIdPos());
    }

    @Test
    public void testSetIdPos() {
        posicion.setIdPos(2);
        assertEquals(2, posicion.getIdPos());
    }

    @Test
    public void testGetCoordenadaX() {
        assertEquals(1.0f, posicion.getCoordenadaX(), 0.01);
    }

    @Test
    public void testSetCoordenadaX() {
        posicion.setCoordenadaX(2.0f);
        assertEquals(2.0f, posicion.getCoordenadaX(), 0.01);
    }

    @Test
    public void testGetCoordenadaY() {
        assertEquals(1.0f, posicion.getCoordenadaY(), 0.01);
    }

    @Test
    public void testSetCoordenadaY() {
        posicion.setCoordenadaY(2.0f);
        assertEquals(2.0f, posicion.getCoordenadaY(), 0.01);
    }

    @Test
    public void testGetFechaHora() {
        assertEquals(date, posicion.getFechaHora());
    }

    @Test
    public void testSetFechaHora() {
        Date newDate = new Date();
        posicion.setFechaHora(newDate);
        assertEquals(newDate, posicion.getFechaHora());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuarioMock, posicion.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        Usuario newUsuarioMock = Mockito.mock(Usuario.class);
        posicion.setUsuario(newUsuarioMock);
        assertEquals(newUsuarioMock, posicion.getUsuario());
    }
}
