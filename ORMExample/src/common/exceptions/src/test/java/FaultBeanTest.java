import com.ucab.cmcapp.common.exceptions.FaultBean;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FaultBeanTest {

    private FaultBean faultBean;
    private final String code = "code1";
    private final String message = "message1";
    private final String supportMessage = "supportMessage1";

    @Before
    public void setUp() {
        faultBean = new FaultBean(code, message, supportMessage);
    }

    @Test
    public void testGetCode() {
        assertEquals(code, faultBean.getCode());
    }

    @Test
    public void testSetAndGetCode() {
        String newCode = "code2";
        faultBean.setCode(newCode);
        assertEquals(newCode, faultBean.getCode());
    }

    @Test
    public void testGetMessage() {
        assertEquals(message, faultBean.getMessage());
    }

    @Test
    public void testSetAndGetMessage() {
        String newMessage = "message2";
        faultBean.setMessage(newMessage);
        assertEquals(newMessage, faultBean.getMessage());
    }

    @Test
    public void testGetSoportMessage() {
        assertEquals(supportMessage, faultBean.getSoportMessage());
    }

    @Test
    public void testSetAndGetSoportMessage() {
        String newSupportMessage = "supportMessage2";
        faultBean.setSoportMessage(newSupportMessage);
        assertEquals(newSupportMessage, faultBean.getSoportMessage());
    }
}
