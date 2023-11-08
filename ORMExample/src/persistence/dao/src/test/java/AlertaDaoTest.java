import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import com.ucab.cmcapp.persistence.dao.AlertaDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlertaDaoTest {

    @Mock
    private DBHandler dbHandler;

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private CriteriaQuery<Alerta> criteriaQuery;

    @Mock
    private Root<Alerta> root;

    private AlertaDao alertaDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(dbHandler.getSession()).thenReturn(entityManager);
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Alerta.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Alerta.class)).thenReturn(root);
        alertaDao = new AlertaDao(dbHandler);
    }

    @Test
    public void testGetAlertaByTipoAlerta() {
        String tipoAlerta = "test";
        Alerta alerta = new Alerta();
        TypedQuery<Alerta> query = null;
        when(entityManager.createQuery(criteriaQuery)).thenReturn(query);
        when(query.getSingleResult()).thenReturn(alerta);

        Alerta result = alertaDao.getAlertaByTipoAlerta(tipoAlerta);

        verify(entityManager, times(1)).createQuery(criteriaQuery);
        verify(query, times(1)).getSingleResult();
        assertEquals(alerta, result);
    }

    @Test(expected = CupraException.class)
    public void testGetAlertaByTipoAlertaThrowsException() {
        String tipoAlerta = "test";
        when(entityManager.createQuery(criteriaQuery)).thenThrow(new RuntimeException());

        alertaDao.getAlertaByTipoAlerta(tipoAlerta);
    }

    @Test
    public void testGetAlertaByTipoAlertaNoResult() {
        String tipoAlerta = "test";
        when(entityManager.createQuery(criteriaQuery)).thenThrow(new NoResultException());

        Alerta result = alertaDao.getAlertaByTipoAlerta(tipoAlerta);

        assertNull(result);
    }

    private void assertNull(Alerta result) {
    }
}