import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import com.ucab.cmcapp.persistence.DaoFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

public class testAddAlertaCommand {


    @Mock
    private DBHandler mockDBHandler;

    @Mock
    private AlertaDao mockAlertaDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() throws Exception {
        // Create a sample Alerta
        Alerta alerta = new Alerta(/* initialize with appropriate values */);

        // Create an instance of the AddAlertaCommand
        AddAlertaCommand addAlertaCommand = new AddAlertaCommand(alerta, mockDBHandler);

        // Mock the behavior of the DAO and execute the command
        Mockito.when(DaoFactory.createAlertaDao(mockDBHandler)).thenReturn(mockAlertaDao);
        Mockito.when(mockAlertaDao.insert(alerta)).thenReturn(alerta);
        addAlertaCommand.execute();

        // Verify that the insert method was called and returned the expected Alerta
        Mockito.verify(mockAlertaDao).insert(alerta);

        // Check the result
        Alerta result = addAlertaCommand.getReturnParam();
        assertEquals(alerta, result);
    }

    @Test
    public void testCloseHandlerSession() throws Exception {
        AddAlertaCommand addAlertaCommand = new AddAlertaCommand(new Alerta());
        addAlertaCommand.setHandler(mockDBHandler);

        addAlertaCommand.closeHandlerSession();

        // Verify that the closeSession method of the DBHandler was called
        Mockito.verify(mockDBHandler).closeSession();
    }
}
