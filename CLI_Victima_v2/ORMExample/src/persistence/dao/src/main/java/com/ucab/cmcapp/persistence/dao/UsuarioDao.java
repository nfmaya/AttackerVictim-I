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


public class UsuarioDao extends BaseDao<Usuario>
{
    private static Logger _logger = LoggerFactory.getLogger( UsuarioDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public UsuarioDao()
    {
        super();
    }

    public UsuarioDao( DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

    public Usuario getUsuarioByUsername( String Username )
    {
        Usuario result = EntityFactory.createUsuario();
        _logger.debug( String.format( "Get in UsuarioDao.getUsuarioByUsername: parameter {%s}", Username ) );
        try
        {
            CriteriaQuery<Usuario> query = _builder.createQuery( Usuario.class );
            Root<Usuario> root = query.from( Usuario.class );

            query.select( root );
            query.where( _builder.equal( root.get( "_Username" ), Username ) );

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

}
