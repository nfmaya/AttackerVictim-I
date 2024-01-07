import com.ucab.cmcapp.common.exceptions.BadIdException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadIdExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        BadIdException exception = new BadIdException(message);
        assertEquals("Invalid Id: " + message, exception.getMessage());
    }
}
