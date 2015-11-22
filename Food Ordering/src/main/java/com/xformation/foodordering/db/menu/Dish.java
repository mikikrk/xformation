package com.xformation.foodordering.db.menu;

/**
 * Created by Mikolaj on 2015-11-18.
 */
public class Dish {
    private int id;
    private String name;
    private String description;
    private double price;
    private DishType type;

    public Dish() {
    }

    public Dish(String name, String description, float price, DishType type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer(name);
        stringBuffer
                .append("\n\t")
                .append(description)
                .append("\t")
                .append(price);
        return stringBuffer.toString();
    }
}
