## Objectives:

In this laboratory work, I implemented three creational design patterns in a small project. The main goal was to understand how to manage object creation in different scenarios and apply these patterns effectively. I used Java for this task and organized the project into packages to keep the code structured.

## Patterns Implemented:

### 1. Singleton Pattern

The Singleton pattern is used to ensure that only one instance of a class is created during the program's execution. In my project, I used this pattern for the OrderManager class, which handles the processing of orders.

**Code Example:**
```java
java
Copy code
public class OrderManager {
private static OrderManager instance;
private List<Order> processedOrders = new ArrayList<>();

    private OrderManager() {}

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
```

In this example, the OrderManager class ensures that the getInstance() method always returns the same instance. This is useful because I need one order manager to handle all orders.

### 2. Builder Pattern

The Builder pattern helps construct complex objects step-by-step. In my project, I used it to create an Order object, which consists of a customer and a list of products.

**Code Example:**
```java
java
Copy code
public class OrderBuilder {
private List<Product> products = new ArrayList<>();
private String customerName;

    public OrderBuilder setCustomerName(String name) {
        this.customerName = name;
        return this;
    }

    public OrderBuilder addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public Order build() {
        if (customerName == null || products.isEmpty()) {
            throw new IllegalStateException("Order must have a customer and at least one product");
        }
        return new Order(customerName, products);
    }
}
```

This pattern allowed me to easily set different parts of an order (like the customer name and the products), and once everything was set, I could build the final Order object. This makes the code flexible and easier to maintain.

### 3. Factory Method Pattern

The Factory Method pattern is used to create objects without exposing the creation logic. I used this pattern to create different types of Product objects in my project. For example, depending on the input, the factory would return an electronic product or a furniture product.

**Code Example:**
```java
java
Copy code
public class ProductFactory {
public Product createProduct(String type) {
switch (type.toLowerCase()) {
case "electronics":
return new Product("Laptop", 1200.0, "Electronics", "A high-end gaming laptop.");
case "furniture":
return new Product("Chair", 150.0, "Furniture", "An ergonomic office chair.");
default:
throw new IllegalArgumentException("Unknown product type: " + type);
}
}
}
```

This method lets me easily add new product types without changing the logic of how they are created. It keeps the code clean and allows flexibility in object creation.

## Project Structure:

The project is divided into several packages to keep everything organized:

```
src/
├── client/
│   └── Main.java
├── domain/
│   ├── Product.java
│   ├── Customer.java
│   └── Order.java
├── factory/
│   └── ProductFactory.java
├── models/
│   └── OrderBuilder.java
└── service/
└── OrderManager.java
```
client: Contains the main application logic.

domain: Contains the Product, Order, and Customer classes.

factory: Includes the ProductFactory, which creates products.

models: Contains the OrderBuilder used to build orders.

service: Includes the OrderManager, which processes orders using the Singleton pattern.

## Main Application Flow:

In the Main class, I demonstrated how these patterns work together. First, I created products using the ProductFactory. Then, I used the OrderBuilder to create an order for a customer, and finally, I processed that order using the OrderManager (Singleton).

Main.java:

```java
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

        // Print customer details and order history
        Customer customer = new Customer("John Doe");
        customer.addOrder(order);
        System.out.println(customer);

        // Show processed orders using Singleton OrderManager
        System.out.println("Processed Orders: " + orderManager.getProcessedOrders());
    }
}
```

## Conclusion:

In this laboratory work, I implemented three creational design patterns—Singleton, Builder, and Factory Method. These patterns helped me manage object creation more effectively, keeping my code clean and flexible. The Singleton pattern ensured there was only one OrderManager, the Builder pattern simplified the creation of complex Order objects, and the Factory Method allowed for the flexible creation of Product objects.

By using these patterns, I was able to better organize the code and ensure that object creation was done in a controlled and maintainable way.