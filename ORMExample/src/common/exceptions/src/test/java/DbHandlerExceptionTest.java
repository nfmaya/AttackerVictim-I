import org.junit.Test;
import com.ucab.cmcapp.common.exceptions.DbHandlerException;
import static org.junit.Assert.assertEquals;

public class DbHandlerExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        DbHandlerException exception = new DbHandlerException(message);
        assertEquals(message, exception.getMessage());
    }
}
