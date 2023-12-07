import com.ucab.cmcapp.common.exceptions.JWTSetKeyException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JWTSetKeyExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        JWTSetKeyException exception = new JWTSetKeyException(message);
        assertEquals(message, exception.getMessage());
    }
}
