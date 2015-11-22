package com.xformation.foodordering.db.ordering;

import com.xformation.foodordering.db.menu.Dish;

/**
 * Created by Mikolaj on 2015-11-21.
 */
public class LunchOrder implements Order{
    private int id;
    private Dish mainCourse;
    private Dish dessert;
    private double cost;

    public LunchOrder() {
    }

    public LunchOrder(Dish mainCourse, Dish dessert) {
        this.mainCourse = mainCourse;
        this.dessert = dessert;
        this.cost = mainCourse.getPrice() + dessert.getPrice();
    }

    @Override
    public String toString() {
        return "Lunch:\n\tMain course: " + mainCourse.getName() + "\n\tDessert: " + dessert.getName();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getMainCourse() {
        return this.mainCourse;
    }

    public void setMainCourse(Dish mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Dish getDessert() {
        return this.dessert;
    }

    public void setDessert(Dish dessert) {
        this.dessert = dessert;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
