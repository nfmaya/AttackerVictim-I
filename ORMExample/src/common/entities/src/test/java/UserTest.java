import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.UserType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserTest {

    private User user;
    private UserType userTypeMock;
    private Date date;

    @Before
    public void setUp() {
        userTypeMock = Mockito.mock(UserType.class);
        date = new Date();
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setUid("123456");
        user.setTermCondition(true);
        user.setCreateAt(date);
        user.setUserType(userTypeMock);
    }
    @Test
    public void testDefaultConstructor() {
        User defaultUser = new User();
        assertNull(defaultUser.getEmail());
        assertNull(defaultUser.getUid());
        assertNull(defaultUser.getTermCondition());
        assertNull(defaultUser.getCreateAt());
        assertNull(defaultUser.getUserType());
    }

    @Test
    public void testCopyConstructor() {
        User copy = new User(user);
        assertEquals(user.getEmail(), copy.getEmail());
        assertEquals(user.getTermCondition(), copy.getTermCondition());
        assertEquals(user.getCreateAt(), copy.getCreateAt());
        assertEquals(user.getUserType(), copy.getUserType());
    }

    @Test
    public void testIdConstructor() {
        long id = 1L;
        User idUser = new User(id);
        assertEquals(id, idUser.getId());
    }
    @Test
    public void testGetId() {
        assertEquals(1, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("newtest@example.com");
        assertEquals("newtest@example.com", user.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testGetUid() {
        assertEquals("123456", user.getUid());
    }

    @Test
    public void testSetUid() {
        user.setUid("654321");
        assertEquals("654321", user.getUid());
    }

    @Test
    public void testGetTermCondition() {
        assertEquals(true, user.getTermCondition());
    }

    @Test
    public void testSetTermCondition() {
        user.setTermCondition(false);
        assertEquals(false, user.getTermCondition());
    }

    @Test
    public void testGetCreateAt() {
        assertEquals(date, user.getCreateAt());
    }

    @Test
    public void testSetCreateAt() {
        Date newDate = new Date();
        user.setCreateAt(newDate);
        assertEquals(newDate, user.getCreateAt());
    }

    @Test
    public void testGetUserType() {
        assertEquals(userTypeMock, user.getUserType());
    }

    @Test
    public void testSetUserType() {
        UserType newUserTypeMock = Mockito.mock(UserType.class);
        user.setUserType(newUserTypeMock);
        assertEquals(newUserTypeMock, user.getUserType());
    }
}
