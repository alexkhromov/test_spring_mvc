package by.academy.rms.service.task;

import by.academy.rms.dao.Dao;
import by.academy.rms.dao.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class BaseService< T, PK extends Serializable > implements IService< T, PK > {

    @Autowired
    private Dao dao;

    public T get( PK id ) throws DaoException {

        return ( T ) dao.get( id );
    }

    public List <T > getAll() throws DaoException {

        return dao.getAll();
    }

    public T add( T object ) throws DaoException {

        return ( T ) dao.add( object );
    }

    public void update( T object ) throws DaoException {

        dao.update( object );
    }

    public void delete( T object ) throws DaoException {

        dao.delete( object );
    }

    public Criteria getCriteria() throws DaoException {

        return dao.getCriteria();
    }

    public Query getQuery( String hql ) throws DaoException {

        return dao.getQuery( hql );
    }

    public void setType( Class< T > type ) {

        dao.setType( type );
    }
}