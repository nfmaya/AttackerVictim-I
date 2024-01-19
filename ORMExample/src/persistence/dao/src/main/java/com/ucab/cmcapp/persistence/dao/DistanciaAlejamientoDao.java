package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class DistanciaAlejamientoDao extends BaseDao<DistanciaAlejamiento>
{
    private static Logger _logger = LoggerFactory.getLogger( DistanciaAlejamientoDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public DistanciaAlejamientoDao()
    {
        super();
    }

    public DistanciaAlejamientoDao( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public List<DistanciaAlejamiento> getDistanciaAlejamientoByUsuarios(long id) {
        List<DistanciaAlejamiento> result = null;
        _logger.debug(String.format("Get in DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: parameters ", id));
        try {
            CriteriaQuery<DistanciaAlejamiento> criteriaQuery = _builder.createQuery(DistanciaAlejamiento.class);
            Root<DistanciaAlejamiento> root = criteriaQuery.from(DistanciaAlejamiento.class);

            Query query = _em.createQuery("FROM DistanciaAlejamiento WHERE _victima.id = :idUsuario", DistanciaAlejamiento.class);
            query.setParameter("idUsuario", id);

            result = query.getResultList();

        } catch (NoResultException e) {
            _logger.error(String.format("Error DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: No Result {%s}", e.getMessage()));
        } catch (Exception e) {
            _logger.error(String.format("Error DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: {%s}", e.getMessage()));
            throw new CupraException(e.getMessage());
        }
        //region Instrumentation
        _logger.debug(String.format("Leaving DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: result {%s}", result));
        //endregion

        return result;
    }


}
