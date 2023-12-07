import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CoordenadaZonaSeguridadTest {

    private CoordenadaZonaSeguridad coordenadaZonaSeguridad;
    private ZonaSeguridad zonaSeguridadMock;

    @Before
    public void setUp() {
        zonaSeguridadMock = Mockito.mock(ZonaSeguridad.class);
        coordenadaZonaSeguridad = new CoordenadaZonaSeguridad();
        coordenadaZonaSeguridad.setIdCoor(1);
        coordenadaZonaSeguridad.setCoordenadaX(1.0f);
        coordenadaZonaSeguridad.setCoordenadaY(1.0f);
        coordenadaZonaSeguridad.setZonaSeguridad(zonaSeguridadMock);
    }
    @Test
    public void testDefaultConstructor() {
        CoordenadaZonaSeguridad defaultCoordenada = new CoordenadaZonaSeguridad();
        assertEquals(0.0, defaultCoordenada.getCoordenadaX(), 0.001);
        assertEquals(0.0, defaultCoordenada.getCoordenadaY(), 0.001);
        assertNull(defaultCoordenada.getZonaSeguridad());
    }

    @Test
    public void testCopyConstructor() {
        CoordenadaZonaSeguridad copy = new CoordenadaZonaSeguridad(coordenadaZonaSeguridad);
        assertEquals(coordenadaZonaSeguridad.getCoordenadaX(), copy.getCoordenadaX(), 0.001);
        assertEquals(coordenadaZonaSeguridad.getCoordenadaY(), copy.getCoordenadaY(), 0.001);
        assertEquals(coordenadaZonaSeguridad.getZonaSeguridad(), copy.getZonaSeguridad());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        CoordenadaZonaSeguridad idCoordenada = new CoordenadaZonaSeguridad(id);
        assertEquals(id, idCoordenada.getIdCoor());
    }
    @Test
    public void testGetIdCoor() {
        assertEquals(1, coordenadaZonaSeguridad.getIdCoor());
    }

    @Test
    public void testSetIdCoor() {
        coordenadaZonaSeguridad.setIdCoor(2);
        assertEquals(2, coordenadaZonaSeguridad.getIdCoor());
    }

    @Test
    public void testGetCoordenadaX() {
        assertEquals(1.0f, coordenadaZonaSeguridad.getCoordenadaX(), 0.01);
    }

    @Test
    public void testSetCoordenadaX() {
        coordenadaZonaSeguridad.setCoordenadaX(2.0f);
        assertEquals(2.0f, coordenadaZonaSeguridad.getCoordenadaX(), 0.01);
    }

    @Test
    public void testGetCoordenadaY() {
        assertEquals(1.0f, coordenadaZonaSeguridad.getCoordenadaY(), 0.01);
    }

    @Test
    public void testSetCoordenadaY() {
        coordenadaZonaSeguridad.setCoordenadaY(2.0f);
        assertEquals(2.0f, coordenadaZonaSeguridad.getCoordenadaY(), 0.01);
    }

    @Test
    public void testGetZonaSeguridad() {
        assertEquals(zonaSeguridadMock, coordenadaZonaSeguridad.getZonaSeguridad());
    }

    @Test
    public void testSetZonaSeguridad() {
        ZonaSeguridad newZonaSeguridadMock = Mockito.mock(ZonaSeguridad.class);
        coordenadaZonaSeguridad.setZonaSeguridad(newZonaSeguridadMock);
        assertEquals(newZonaSeguridadMock, coordenadaZonaSeguridad.getZonaSeguridad());
    }
}
