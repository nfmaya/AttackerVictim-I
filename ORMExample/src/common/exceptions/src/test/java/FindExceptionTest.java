import com.ucab.cmcapp.common.exceptions.FindException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        FindException exception = new FindException(message);
        assertEquals(message, exception.getMessage());
    }
}
