package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.PuntoControl;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class PuntoControlDao extends BaseDao<PuntoControl>
{
    private static Logger _logger = LoggerFactory.getLogger( PuntoControlDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public PuntoControlDao()
    {
        super();
    }

    public PuntoControlDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
