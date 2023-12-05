import com.ucab.cmcapp.common.exceptions.AuthenticationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        AuthenticationException exception = new AuthenticationException(message);
        assertEquals(message, exception.getMessage());
    }
}
