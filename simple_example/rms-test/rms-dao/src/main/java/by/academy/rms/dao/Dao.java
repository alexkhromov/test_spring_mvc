package by.academy.rms.dao;

import by.academy.rms.dao.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @param <PK>
 */
public interface Dao<T, PK extends Serializable> {

    /**
     * Get persisted objects using primary key
     *
     * @throws by.academy.rms.dao.exceptions.DaoException
     *
     */
    List<T> getAll() throws DaoException;

    /**
     * Get persisted object using primary key
     *
     * @throws DaoException
     */
    T get(PK id) throws DaoException;

    /**
     * Persist the new instance object
     *
     * @throws DaoException
     */
    T add(T object) throws DaoException;

    /**
     * Save changes made to a transient object.
     *
     * @throws DaoException
     */
    void update(T object) throws DaoException;

    /**
     * Remove an object
     *
     * @throws DaoException
     */
    void delete(T object) throws DaoException;

    /**
     * Return created criteria
     *
     * @throws DaoException
     */
    Criteria getCriteria() throws DaoException;

    /**
     * Return created criteria
     *
     * @throws DaoException
     */
    Query getQuery(String hql) throws DaoException;

    void setType( Class< T > type );
 }