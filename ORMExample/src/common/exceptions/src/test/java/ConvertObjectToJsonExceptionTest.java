import com.ucab.cmcapp.common.exceptions.ConvertObjectToJsonException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertObjectToJsonExceptionTest {

    @Test
    public void testExceptionMessage() {
        String message = "Test message";
        ConvertObjectToJsonException exception = new ConvertObjectToJsonException(message);
        assertEquals(message, exception.getMessage());
    }
}
