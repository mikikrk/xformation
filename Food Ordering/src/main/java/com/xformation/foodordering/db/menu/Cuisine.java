package com.xformation.foodordering.db.menu;

import java.util.Set;

/**
 * Created by Mikolaj on 2015-11-18.
 */
public class Cuisine {
    private int id;
    private String name;
    private Set<Dish> dishes;

    public Cuisine() {
    }

    public Cuisine(String name, Set<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return name;
    }
}
