import com.ucab.cmcapp.common.exceptions.CupraException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CupraExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        CupraException exception = new CupraException(message);
        assertEquals(message, exception.getMessage());
    }
}
