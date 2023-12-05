import com.ucab.cmcapp.common.entities.UserType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTypeTest {

    private UserType userType;

    @Before
    public void setUp() {
        userType = new UserType();
        userType.setId(1);
        userType.setName("Test");
    }

    @Test
    public void testGetId() {
        assertEquals(1, userType.getId());
    }

    @Test
    public void testSetId() {
        userType.setId(2);
        assertEquals(2, userType.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test", userType.getName());
    }

    @Test
    public void testSetName() {
        userType.setName("New Test");
        assertEquals("New Test", userType.getName());
    }
}
