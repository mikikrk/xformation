package com.xformation.foodordering.db;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mikolaj on 2015-11-21.
 */
public abstract class DAO {
    protected SessionFactory sessionFactory;

    public DAO() {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    protected Object getUniqueResult(String hql, String parameterName, Object parameter){
        Object result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(parameterName, parameter);
            result = query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }
}
