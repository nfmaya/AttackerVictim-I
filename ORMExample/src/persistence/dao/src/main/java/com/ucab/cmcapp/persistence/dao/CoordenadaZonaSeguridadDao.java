package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.CoordenadaZonaSeguridad;
import com.ucab.cmcapp.common.entities.Posicion;
import com.ucab.cmcapp.common.entities.Usuario;
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
/*
    public List<CoordenadaZonaSeguridad> getCoordenadaZonaSeguridadByIdZona(long id)
    {
        CoordenadaZonaSeguridad result = EntityFactory.createCoordenadaZonaSeguridad();
        _logger.debug( String.format( "Get in UsuarioDao.getUsuarioByUsername: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<CoordenadaZonaSeguridad> query = _builder.createQuery( CoordenadaZonaSeguridad.class );
            Root<CoordenadaZonaSeguridad> root = query.from( CoordenadaZonaSeguridad.class );

            Query query = _builder.createQuery("FROM CoordenadaZonaSeguridad WHERE zonaSeguridad.id = :idZona", CoordenadaZonaSeguridad.class);
            query.setParameter("idZona", idZona);

            result = _em.createQuery( query ).getSingleResult();
        }
        catch ( NoResultException e )
        {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByUsername: No Result {%s}", e.getMessage() ) );
        }
        catch ( Exception e )
        {
            _logger.error( String.format( "Error UsuarioDao.getUsuarioByUsername: {%s}", e.getMessage() ) );
            throw new CupraException( e.getMessage() );
        }
        //region Instrumentation
        _logger.debug( String.format( "Leavin UsuarioDao.getUsuarioByUsername: result {%s}", result ) );
        //endregion

        return result;
    }
hok
 */
}
