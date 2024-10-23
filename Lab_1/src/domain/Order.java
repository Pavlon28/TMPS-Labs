package Lab_1.src.domain;

import java.util.List;

public class Order {
    private String customerName;
    private List<Product> products;

    public Order(String customerName, List<Product> products) {
        this.customerName = customerName;
        this.products = products;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order for " + customerName + " with total price: $" + getTotalPrice() + ", Products: " + products;
    }
}