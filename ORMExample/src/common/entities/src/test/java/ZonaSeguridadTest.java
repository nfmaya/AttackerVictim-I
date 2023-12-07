import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ZonaSeguridadTest {

    private ZonaSeguridad zonaSeguridad;

    @Before
    public void setUp() {
        zonaSeguridad = new ZonaSeguridad();
        zonaSeguridad.setIdZona(1);
        zonaSeguridad.setNombreZona("Test");
    }
    @Test
    public void testDefaultConstructor() {
        ZonaSeguridad defaultZonaSeguridad = new ZonaSeguridad();
        assertNull(defaultZonaSeguridad.getNombreZona());
    }

    @Test
    public void testNombreConstructor() {
        String nombreZona = "Test";
        ZonaSeguridad nombreZonaSeguridad = new ZonaSeguridad(nombreZona);
        assertEquals(nombreZona, nombreZonaSeguridad.getNombreZona());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        ZonaSeguridad idZonaSeguridad = new ZonaSeguridad(id);
        assertEquals(id, idZonaSeguridad.getIdZona());
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
