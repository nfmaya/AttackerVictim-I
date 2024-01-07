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


public class AlertaDao extends BaseDao<Alerta>
{
    private static Logger _logger = LoggerFactory.getLogger( AlertaDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public AlertaDao()
    {
        super();
    }

    public AlertaDao( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Alerta getAlertaByTipoAlerta( String TipoAlerta )
    {
        Alerta result = EntityFactory.createAlerta();
        _logger.debug( String.format( "Get in AlertaDao.getAlertaByTipoAlerta: parameter {%s}", TipoAlerta ) );
        try
        {
            CriteriaQuery<Alerta> query = _builder.createQuery( Alerta.class );
            Root<Alerta> root = query.from( Alerta.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_tipoAlerta" ), TipoAlerta ) );

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error AlertaDao.getAlertaByTipoAlerta: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error AlertaDao.getAlertaByTipoAlerta: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin AlertaDao.getAlertaByTipoAlerta: result {%s}", result ) );
        //endregion

        return result;
    }

}
