package com.xformation.foodordering.db.ordering;

import com.xformation.foodordering.db.menu.Dish;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

/**
 * Created by Mikolaj on 2015-11-21.
 */
public class DrinkOrder implements Order{
    private int id;
    private Dish drink;
    private boolean ice;
    private boolean lemon;
    private double cost;

    public DrinkOrder() {
    }

    public DrinkOrder(Dish drink, boolean ice, boolean lemon) {
        this.drink = drink;
        this.ice = ice;
        this.lemon = lemon;
        this.cost = drink.getPrice();
    }

    @Override
    public String toString() {
        return drink.getName() + ((ice || lemon) ? " with " : "") + (ice ? (lemon ? "ice and lemon" : "ice") : (lemon ? "lemon" : ""));
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDrink() {
        return this.drink;
    }

    public void setDrink(Dish drink) {
        this.drink = drink;
    }

    public boolean isIce() {
        return this.ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public boolean isLemon() {
        return this.lemon;
    }

    public void setLemon(boolean lemon) {
        this.lemon = lemon;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
