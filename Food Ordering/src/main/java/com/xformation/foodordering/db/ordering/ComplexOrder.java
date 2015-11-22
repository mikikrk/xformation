package com.xformation.foodordering.db.ordering;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Mikolaj on 2015-11-19.
 */
public class ComplexOrder implements Order{
    private int id;
    private List<LunchOrder> lunchOrders;
    private List<DrinkOrder> drinkOrders;
    private double cost = 0;

    public ComplexOrder() {
        lunchOrders = new LinkedList<>();
        drinkOrders = new LinkedList<>();
    }

    public void addOrder(Order order){
        if (order instanceof LunchOrder){
            lunchOrders.add((LunchOrder) order);
        } else if (order instanceof DrinkOrder){
            drinkOrders.add((DrinkOrder) order);
        }
        cost += order.getCost();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        addOrdersToBill(stringBuffer, lunchOrders);
        addOrdersToBill(stringBuffer, drinkOrders);
        stringBuffer.append("Total cost is " + cost + "\n");
        return stringBuffer.toString();
    }

    private void addOrdersToBill(StringBuffer stringBuffer, List orders){
        Optional<String> ordersString = ordersToString(orders);
        ordersString.ifPresent((string) -> stringBuffer.append(ordersString.get()));
        stringBuffer.append("\n");
    }

    private Optional<String> ordersToString(List orders){
        return orders.stream()
                .map((order) -> order.toString())
                .reduce((orderString1, orderString2) -> orderString1 + "\n" + orderString2);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LunchOrder> getLunchOrders() {
        return this.lunchOrders;
    }

    public void setLunchOrders(List<LunchOrder> lunchOrders) {
        this.lunchOrders = lunchOrders;
    }

    public List<DrinkOrder> getDrinkOrders() {
        return this.drinkOrders;
    }

    public void setDrinkOrders(List<DrinkOrder> drinkOrders) {
        this.drinkOrders = drinkOrders;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
