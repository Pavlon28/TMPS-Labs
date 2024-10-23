package Lab_1.src.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public String toString() {
        return name + " with order history: " + orderHistory;
    }
}