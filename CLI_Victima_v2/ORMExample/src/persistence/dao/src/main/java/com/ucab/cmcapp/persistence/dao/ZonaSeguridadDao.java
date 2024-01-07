package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class ZonaSeguridadDao extends BaseDao<ZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ZonaSeguridadDao()
    {
        super();
    }

    public ZonaSeguridadDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
