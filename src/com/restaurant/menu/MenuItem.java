package com.restaurant.menu;

public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Rp." + price;
    }
}
