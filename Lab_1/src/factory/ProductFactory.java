package Lab_1.src.factory;

import Lab_1.src.domain.Product;

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
