package com.ucab.cmcapp.persistence.dao;

import com.ucab.cmcapp.common.entities.TiempoControl;
import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.persistence.DBHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


public class UserTypeDao extends BaseDao<UserType>
{
    private static Logger _logger = LoggerFactory.getLogger( UserTypeDao.class );
    private EntityManager _em;
    private CriteriaBuilder _builder;


    public UserTypeDao()
    {
        super();
    }

    public UserTypeDao(DBHandler handler )
    {
        super( handler );

        _em = getDBHandler().getSession();
        _builder = _em.getCriteriaBuilder();
    }

}
