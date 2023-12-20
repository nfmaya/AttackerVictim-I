package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
import com.ucab.cmcapp.common.entities.ZonaSeguridad;
import com.ucab.cmcapp.common.entities.ZonaSeguridadUsuario;
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

    public List<ZonaSeguridadUsuario> getZonaSeguridadUsuarioByIdUsuario(long id)
    {
        List<ZonaSeguridadUsuario> result = null;
        _logger.debug( String.format( "Get in UsuarioDao.getUsuarioByUsername: parameter {%s}", id ) );
        try
        {
            CriteriaQuery<ZonaSeguridadUsuario> criteriaQuery = _builder.createQuery( ZonaSeguridadUsuario.class );
            Root<ZonaSeguridadUsuario> root = criteriaQuery.from( ZonaSeguridadUsuario.class );

            Query query = _em.createQuery("FROM ZonaSeguridadUsuario WHERE usuario.id = :IdUsuario", ZonaSeguridadUsuario.class);
            query.setParameter("IdUsuario", id);
            result = query.getResultList();
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

}
