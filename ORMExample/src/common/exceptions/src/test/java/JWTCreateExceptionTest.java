import com.ucab.cmcapp.common.exceptions.JWTCreateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JWTCreateExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        JWTCreateException exception = new JWTCreateException(message);
        assertEquals(message, exception.getMessage());
    }
}
