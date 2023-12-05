import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZonaSeguridadTest {

    private ZonaSeguridad zonaSeguridad;

    @Before
    public void setUp() {
        zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.setIdZona(1);
        zonaSeguridad.setNombreZona("Test");
    }

    @Test
    public void testGetIdZona() {
        assertEquals(1, zonaSeguridad.getIdZona());
    }

    @Test
    public void testSetIdZona() {
        zonaSeguridad.setIdZona(2);
        assertEquals(2, zonaSeguridad.getIdZona());
    }

    @Test
    public void testGetNombreZona() {
        assertEquals("Test", zonaSeguridad.getNombreZona());
    }

    @Test
    public void testSetNombreZona() {
        zonaSeguridad.setNombreZona("New Test");
        assertEquals("New Test", zonaSeguridad.getNombreZona());
    }
}
