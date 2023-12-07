import com.ucab.cmcapp.common.entities.DistanciaAlejamiento;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class DistanciaAlejamientoTest {

    private DistanciaAlejamiento distanciaAlejamiento;
    private Usuario victimaMock;
    private Usuario agresorMock;

    @Before
    public void setUp() {
        victimaMock = Mockito.mock(Usuario.class);
        agresorMock = Mockito.mock(Usuario.class);
        distanciaAlejamiento = new DistanciaAlejamiento();
        distanciaAlejamiento.set_IdAlej(1);
        distanciaAlejamiento.set_distanciaMinima(1.0f);
        distanciaAlejamiento.set_victima(victimaMock);
        distanciaAlejamiento.set_agresor(agresorMock);
    }
    @Test
    public void testCopyConstructor() {

        distanciaAlejamiento.set_distanciaMinima(1.0f);
        Usuario victimaMock = Mockito.mock(Usuario.class);
        distanciaAlejamiento.set_victima(victimaMock);
        Usuario agresorMock = Mockito.mock(Usuario.class);
        distanciaAlejamiento.set_agresor(agresorMock);

        DistanciaAlejamiento copy = new DistanciaAlejamiento(distanciaAlejamiento);
        assertEquals(distanciaAlejamiento.get_distanciaMinima(), copy.get_distanciaMinima(), 0.001);
        assertEquals(distanciaAlejamiento.get_victima(), copy.get_victima());
        assertEquals(distanciaAlejamiento.get_agresor(), copy.get_agresor());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        DistanciaAlejamiento distancia = new DistanciaAlejamiento(id);
        assertEquals(id, distancia.get_IdAlej());
    }

    @Test
    public void testGetIdAlej() {
        assertEquals(1, distanciaAlejamiento.get_IdAlej());
    }

    @Test
    public void testSetIdAlej() {
        distanciaAlejamiento.set_IdAlej(2);
        assertEquals(2, distanciaAlejamiento.get_IdAlej());
    }

    @Test
    public void testGetDistanciaMinima() {
        assertEquals(1.0f, distanciaAlejamiento.get_distanciaMinima(), 0.01);
    }

    @Test
    public void testSetDistanciaMinima() {
        distanciaAlejamiento.set_distanciaMinima(2.0f);
        assertEquals(2.0f, distanciaAlejamiento.get_distanciaMinima(), 0.01);
    }

    @Test
    public void testGetVictima() {
        assertEquals(victimaMock, distanciaAlejamiento.get_victima());
    }

    @Test
    public void testSetVictima() {
        Usuario newVictimaMock = Mockito.mock(Usuario.class);
        distanciaAlejamiento.set_victima(newVictimaMock);
        assertEquals(newVictimaMock, distanciaAlejamiento.get_victima());
    }

    @Test
    public void testGetAgresor() {
        assertEquals(agresorMock, distanciaAlejamiento.get_agresor());
    }

    @Test
    public void testSetAgresor() {
        Usuario newAgresorMock = Mockito.mock(Usuario.class);
        distanciaAlejamiento.set_agresor(newAgresorMock);
        assertEquals(newAgresorMock, distanciaAlejamiento.get_agresor());
    }
}
