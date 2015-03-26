package by.academy.rms.dao;

import by.academy.rms.dao.exceptions.DaoErrorCode;
import by.academy.rms.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

    private static Logger log = Logger.getLogger( DaoImpl.class );

    private SessionFactory sessionFactory;

    private Class<T> type;
    private String typeName;

    public DaoImpl( Class< T > type ) {
        this.type = type;
        this.typeName = type.getSimpleName();
        log.debug(String.format("Created Dao for %s.", typeName));
    }

    public void setSessionFactory( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
	Session session = sessionFactory.getCurrentSession();
	log.debug(String.format("Got current session for %s: %s.", typeName, session));
	return session;
    }

    @Override
    public List<T> getAll() throws DaoException {
        log.debug(String.format("Get all <%s>.", typeName));
        try {
            List<T> list = getSession().createCriteria(type).list();
            log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
            return list;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_001, typeName);
        }
    }

    @Override
    public T get(PK id) throws DaoException {
        try {
            log.debug(String.format("Get %s with id=%s.", typeName, id));
            T o = (T) getSession().get(type, id);
            log.debug(String.format("Got %s: %s.", typeName, o));
            return o;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_000, typeName, id);
        }
    }

    @Override
    public T add(T o) throws DaoException {
        try {
            log.debug(String.format("Create %s: %s.", typeName, o));
            PK id = (PK) getSession().save(o);
            log.debug(String.format("Created %s with id=%s.", typeName, id));
            return get(id);
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_002, o);
        }
    }

    @Override
    public void update(T o) throws DaoException {
        try {
            log.debug(String.format("Update %s: %s.", typeName, o));
            getSession().update(o);
            log.debug(String.format("Updated %s: %s.", typeName, o));
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_003, o);
        }
    }

    @Override
    public void delete(T o) throws DaoException {
        try {
            log.debug(String.format("Delete %s: %s.", typeName, o));
            if (o != null) {
                getSession().delete(o);
                log.debug(String.format("Deleted %s: %s.", typeName, o));
            }
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_004, o);
        }
    }

    @Override
    public Criteria getCriteria() throws DaoException {
        try {
            Criteria criteria = getSession().createCriteria(type);
            log.debug(String.format("Created criteria for type %s.", typeName));
            return criteria;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_005, typeName);
        }
    }

    @Override
    public Query getQuery(String hql) throws DaoException {
        try {
            Query query = getSession().createQuery(hql);
            log.debug(String.format("Created query: %s.", hql));
            return query;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.RMS_DAO_006, hql);
        }
    }

    @Override
    public void setType( Class< T > type ) {

        this.type = type;
        typeName = type.getSimpleName();
    }
}