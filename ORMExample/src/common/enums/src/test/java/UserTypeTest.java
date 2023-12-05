
//nose si se hace esta prueba pero lo hago por si acaso
import com.ucab.cmcapp.common.enums.UserType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTypeTest {

    @Test
    public void testGetValue() {
        assertEquals(1L, UserType.ADMINISTRATOR.getValue().longValue());
        assertEquals(2L, UserType.USER.getValue().longValue());
    }
}
