import com.ucab.cmcapp.common.exceptions.InsertException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        InsertException exception = new InsertException(message);
        assertEquals(message, exception.getMessage());
    }
}
