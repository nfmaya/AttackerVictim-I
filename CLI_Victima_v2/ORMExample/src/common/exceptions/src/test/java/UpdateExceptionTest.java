import com.ucab.cmcapp.common.exceptions.UpdateException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateExceptionTest {

    @Test
    public void testExceptionMessageAndCause() {
        String message = "Test message";
        Exception cause = new Exception("Test cause");
        UpdateException exception = new UpdateException(cause, message);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
