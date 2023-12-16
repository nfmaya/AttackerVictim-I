package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class ZonaSeguridadUsuarioDao extends BaseDao<ZonaSeguridadUsuario>
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguridadUsuarioDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public ZonaSeguridadUsuarioDao()
    {
        super();
    }

    public ZonaSeguridadUsuarioDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
