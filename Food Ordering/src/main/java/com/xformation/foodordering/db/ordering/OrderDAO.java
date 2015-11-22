package com.xformation.foodordering.db.ordering;

import com.xformation.foodordering.db.DAO;
import com.xformation.foodordering.db.menu.Cuisine;
import com.xformation.foodordering.db.menu.Dish;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by Mikolaj on 2015-11-21.
 */
public class OrderDAO extends DAO{

    public Integer addOrder(ComplexOrder order){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer orderID = null;
        try{
            transaction = session.beginTransaction();
            orderID = (Integer) session.save(order);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return orderID;
    }

    public Optional<ComplexOrder> getOrder(Integer orderId){
        String parameterName = "orderId";
        String hql = "FROM ComplexOrder order WHERE order.order_id = :" + parameterName;
        return Optional.of((ComplexOrder) getUniqueResult(hql, parameterName, orderId));
    }

}
