package com.xformation.foodordering.db.menu;

import com.xformation.foodordering.db.DAO;
import com.xformation.foodordering.db.menu.Cuisine;
import com.xformation.foodordering.db.menu.Dish;
import com.xformation.foodordering.db.menu.DishType;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mikolaj on 2015-11-18.
 */
public class MenuDAO extends DAO {

    public Optional<Cuisine> getCuisine(Integer cuisineId){
        String parameterName = "cuisineId";
        String hql = "FROM Cuisine cuisine WHERE cuisine.cuisine_id = :" + parameterName;
        return Optional.of((Cuisine) getUniqueResult(hql, parameterName, cuisineId));
    }

    public Optional<Cuisine> getCuisine(String cuisineName){
        String parameterName = "cuisineName";
        String hql = "FROM Cuisine cuisine WHERE cuisine.name = :" + parameterName;
        return Optional.of((Cuisine) getUniqueResult(hql, parameterName, cuisineName));
    }

    public List<Cuisine> getCuisines(){
        List cuisines = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            String hql = "FROM Cuisine cuisine";
            cuisines = session.createQuery(hql).list();
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cuisines;
    }

    public Integer addCuisine(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer cuisineID = null;
        try{
            transaction = session.beginTransaction();
            Cuisine cuisine = new Cuisine(name, Collections.<Dish>emptySet());
            cuisineID = (Integer) session.save(cuisine);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cuisineID;
    }

    public void updateCuisine(Cuisine cuisine){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            session.update(cuisine);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }



    public Optional<Dish> getDish(Integer dishId){
        String parameterName = "dishId";
        String hql = "FROM Dish dish WHERE dish.dish_id = :" + parameterName;
        return Optional.of((Dish) getUniqueResult(hql, parameterName, dishId));
    }

    public Optional<Dish> getDish(String dishName){
        String parameterName = "dishName";
        String hql = "FROM Dish dish WHERE dish.name = :" + parameterName;
        return Optional.of((Dish) getUniqueResult(hql, parameterName, dishName));
    }

    public List<Dish> getDishes(String cuisine, DishType dishType){
        List dishes = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            String hql = "SELECT dish FROM Cuisine cu INNER JOIN cu.dishes dish where cu.name = :cuisine AND dish.type = :dishType";
            Query query = session.createQuery(hql);
            query.setParameter("cuisine", cuisine);
            query.setParameter("dishType", dishType);
            dishes = query.list();
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dishes;
    }

    public void addDish(String name, String description, float price, DishType type, Cuisine cuisine){
        Dish dish = new Dish(name, description, price, type);
        cuisine.getDishes().add(dish);
        updateCuisine(cuisine);
    }

    public void updateDish(Dish dish){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            session.update(dish);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
