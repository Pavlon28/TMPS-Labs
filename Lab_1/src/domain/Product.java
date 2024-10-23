package Lab_1.src.domain;

public class Product {
    private String name;
    private double price;
    private String category;
    private String description;

    public Product(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    // Getter for price
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ") - " + category + ": " + description;
    }
}
