import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.logic.commands.alerta.atomic.AddAlertaCommand;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.DaoFactory;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddAlertaCommandTest {

    @Test
    public void execute_insertsAlertaWithNonNullIdIntoDatabase() throws Exception {
        Alerta alerta = new Alerta();
        alerta.set_IdAlerta(1);
        DBHandler dbHandler = new DBHandler();
        AlertaDao alertaDao = Mockito.mock(AlertaDao.class);

        Mockito.when(DaoFactory.createAlertaDao(dbHandler)).thenReturn(alertaDao);
        Mockito.when(alertaDao.insert(alerta)).thenReturn(alerta);

        AddAlertaCommand command = new AddAlertaCommand(alerta, dbHandler);
        command.execute();

        Mockito.verify(alertaDao).insert(alerta);
    }

    @Test
    public void execute_insertsAlertaWithNullIdIntoDatabase() throws Exception {
        Alerta alerta = new Alerta();
        alerta.set_IdAlerta(2);
        DBHandler dbHandler = new DBHandler();
        AlertaDao alertaDao = Mockito.mock(AlertaDao.class);

        Mockito.when(DaoFactory.createAlertaDao(dbHandler)).thenReturn(alertaDao);
        Mockito.when(alertaDao.insert(alerta)).thenReturn(alerta);

        AddAlertaCommand command = new AddAlertaCommand(alerta, dbHandler);
        command.execute();

        Mockito.verify(alertaDao).insert(alerta);
    }

    @Test
    public void execute_returnsInsertedAlertaWithNonNullId() throws Exception {
        Alerta alerta = new Alerta();
        alerta.set_IdAlerta(1);
        DBHandler dbHandler = new DBHandler();
        AlertaDao alertaDao = Mockito.mock(AlertaDao.class);

        Mockito.when(DaoFactory.createAlertaDao(dbHandler)).thenReturn(alertaDao);
        Mockito.when(alertaDao.insert(alerta)).thenReturn(alerta);

        AddAlertaCommand command = new AddAlertaCommand(alerta, dbHandler);
        command.execute();

        assertNotNull(command.getReturnParam().get_IdAlerta());
        assertEquals(alerta, command.getReturnParam());
    }

    @Test
    public void execute_returnsInsertedAlertaWithNullId() throws Exception {
        Alerta alerta = new Alerta();
        alerta.set_IdAlerta(2);
        DBHandler dbHandler = new DBHandler();
        AlertaDao alertaDao = Mockito.mock(AlertaDao.class);

        Mockito.when(DaoFactory.createAlertaDao(dbHandler)).thenReturn(alertaDao);
        Mockito.when(alertaDao.insert(alerta)).thenReturn(alerta);

        AddAlertaCommand command = new AddAlertaCommand(alerta, dbHandler);
        command.execute();

        assertEquals(alerta, command.getReturnParam());
    }
}