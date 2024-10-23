package Lab_1.src.models;

import Lab_1.src.domain.Order;
import Lab_1.src.domain.Product;
import java.util.ArrayList;
import java.util.List;

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