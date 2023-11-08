package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class CoordenadaZonaSeguridadDao extends BaseDao<CoordenadaZonaSeguridad>
{
    private static Logger _logger = LoggerFactory.getLogger( CoordenadaZonaSeguridadDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public CoordenadaZonaSeguridadDao()
    {
        super();
    }

    public CoordenadaZonaSeguridadDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
