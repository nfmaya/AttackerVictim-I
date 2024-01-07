import com.ucab.cmcapp.common.entities.TiempoControl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TiempoControlTest {

    private TiempoControl tiempoControl;

    @Before
    public void setUp() {
        tiempoControl = new TiempoControl();
        tiempoControl.setIdTiempo(1);
        tiempoControl.setTipoTiempoControl("Test");
        tiempoControl.setTiempoControl(1.0f);
    }
    @Test
    public void testDefaultConstructor() {
        TiempoControl defaultTiempoControl = new TiempoControl();
        assertEquals(0.0, defaultTiempoControl.getTiempoControl(), 0.001);
        assertNull(defaultTiempoControl.getTipoTiempoControl());
    }

    @Test
    public void testTiempoTipoConstructor() {
        float tiempoControl = 1.0f;
        String tipoTiempoControl = "Test";
        TiempoControl tiempoTipoTiempoControl = new TiempoControl(tiempoControl, tipoTiempoControl);
        assertEquals(tiempoControl, tiempoTipoTiempoControl.getTiempoControl(), 0.001);
        assertEquals(tipoTiempoControl, tiempoTipoTiempoControl.getTipoTiempoControl());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        TiempoControl idTiempoControl = new TiempoControl(id);
        assertEquals(id, idTiempoControl.getIdTiempo());
    }
    @Test
    public void testGetIdTiempo() {
        assertEquals(1, tiempoControl.getIdTiempo());
    }

    @Test
    public void testSetIdTiempo() {
        tiempoControl.setIdTiempo(2);
        assertEquals(2, tiempoControl.getIdTiempo());
    }

    @Test
    public void testGetTipoTiempoControl() {
        assertEquals("Test", tiempoControl.getTipoTiempoControl());
    }

    @Test
    public void testSetTipoTiempoControl() {
        tiempoControl.setTipoTiempoControl("New Test");
        assertEquals("New Test", tiempoControl.getTipoTiempoControl());
    }

    @Test
    public void testGetTiempoControl() {
        assertEquals(1.0f, tiempoControl.getTiempoControl(), 0.01);
    }

    @Test
    public void testSetTiempoControl() {
        tiempoControl.setTiempoControl(2.0f);
        assertEquals(2.0f, tiempoControl.getTiempoControl(), 0.01);
    }
}
