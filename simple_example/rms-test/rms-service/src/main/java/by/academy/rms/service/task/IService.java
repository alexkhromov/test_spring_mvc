package by.academy.rms.service.task;

import by.academy.rms.dao.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

public interface IService< T, PK extends Serializable > {

    public T get( PK id ) throws DaoException;

    public List< T > getAll() throws DaoException;

    public T add( T object ) throws DaoException;

    public void update( T object ) throws DaoException;

    public void delete( T object ) throws DaoException;

    public Criteria getCriteria() throws DaoException;

    public Query getQuery( String hql ) throws DaoException;

    public void setType( Class< T > type );
}
