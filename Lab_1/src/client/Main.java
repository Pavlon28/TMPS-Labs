package Lab_1.src.client;

import Lab_1.src.domain.Customer;
import Lab_1.src.domain.Order;
import Lab_1.src.domain.Product;
import Lab_1.src.factory.ProductFactory;
import Lab_1.src.models.OrderBuilder;
import Lab_1.src.service.OrderManager;

public class Main {
    public static void main(String[] args) {
        // Singleton Example
        OrderManager orderManager = OrderManager.getInstance();

        // Factory Example
        ProductFactory productFactory = new ProductFactory();
        Product product1 = productFactory.createProduct("electronics");
        Product product2 = productFactory.createProduct("furniture");

        // Builder Example
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order = orderBuilder
                .setCustomerName("John Doe")
                .addProduct(product1)
                .addProduct(product2)
                .build();

        // Process the order using Singleton OrderManager
        orderManager.processOrder(order);

        // Create a customer and add order to history
        Customer customer = new Customer("John Doe");
        customer.addOrder(order);

        // Print customer details and order history
        System.out.println(customer);

        // Show processed orders using Singleton OrderManager
        System.out.println("Processed Orders: " + orderManager.getProcessedOrders());
    }
}