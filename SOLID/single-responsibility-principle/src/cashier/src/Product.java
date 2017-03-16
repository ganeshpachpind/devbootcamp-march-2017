import lombok.Getter;

@Getter
class Product {

    private String name;
    private String description;
    private int measure;
    private double price;
    private String unit;

    Product(String name, String description, int measure, double price, String unit) {
        this.name = name;
        this.description = description;
        this.measure = measure;
        this.price = price;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %d(%s)", name, description, price, measure, unit);
    }
}
