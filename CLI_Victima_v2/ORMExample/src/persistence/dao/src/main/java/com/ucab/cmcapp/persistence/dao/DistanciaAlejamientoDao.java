package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.common.exceptions.CupraException;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


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

    public DistanciaAlejamiento getDistanciaAlejamientoByUsuarios(long Victima_id, long Agresor_id) {
        DistanciaAlejamiento result = EntityFactory.createDistanciaAlejamiento();
        _logger.debug(String.format("Get in DistanciaAlejamientoDao.getDistanciaAlejamientoByUsuarios: parameters (Victima_id: %d, Agresor_id: %d)", Victima_id, Agresor_id));
        try {
            CriteriaQuery<DistanciaAlejamiento> query = _builder.createQuery(DistanciaAlejamiento.class);
            Root<DistanciaAlejamiento> root = query.from(DistanciaAlejamiento.class);

            query.select(root);
            query.where(_builder.and(
                    _builder.equal(root.get("_victima"), Victima_id),
                    _builder.equal(root.get("_agresor"), Agresor_id)
            ));

            result = _em.createQuery(query).getSingleResult();
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
