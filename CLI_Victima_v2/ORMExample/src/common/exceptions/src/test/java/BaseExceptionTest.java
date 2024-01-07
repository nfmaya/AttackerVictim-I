import com.ucab.cmcapp.common.exceptions.BaseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        BaseException exception = new BaseException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testExceptionCause() {
        Exception cause = new Exception("Test cause");
        BaseException exception = new BaseException(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testExceptionMessageAndCause() {
        String message = "Test message";
        Exception cause = new Exception("Test cause");
        BaseException exception = new BaseException(cause, message);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    public void testIllegalArgumentException() {
        IllegalArgumentException cause = new IllegalArgumentException("Test cause");
        BaseException exception = new BaseException(cause);
    }

}
