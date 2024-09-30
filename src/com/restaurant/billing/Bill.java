package com.restaurant.billing;

import com.restaurant.order.Order;

public class Bill {
    private Order order;
    private double taxRate;

    public Bill(Order order, double taxRate) {
        this.order = order;
        this.taxRate = taxRate;
    }

    public double calculateTotalWithTax() {
        return order.calculateTotal() + (order.calculateTotal() * taxRate);
    }
}
