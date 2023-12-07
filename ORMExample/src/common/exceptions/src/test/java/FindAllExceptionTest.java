import com.ucab.cmcapp.common.exceptions.FindAllException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FindAllExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Test message";
        FindAllException exception = new FindAllException(message);
        assertEquals(message, exception.getMessage());
    }
}