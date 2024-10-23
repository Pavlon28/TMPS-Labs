package Lab_1.src.service;

import Lab_1.src.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<Order> processedOrders = new ArrayList<>();

    private OrderManager() {
        // private constructor to prevent instantiation
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void processOrder(Order order) {
        processedOrders.add(order);
        System.out.println("Order processed: " + order);
    }

    public List<Order> getProcessedOrders() {
        return processedOrders;
    }
}

