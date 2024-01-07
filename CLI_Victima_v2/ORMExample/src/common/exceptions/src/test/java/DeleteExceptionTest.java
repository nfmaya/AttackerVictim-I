import com.ucab.cmcapp.common.exceptions.DeleteException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        DeleteException exception = new DeleteException(message);
        assertEquals(message, exception.getMessage());
    }
}
