import lombok.Getter;

@Getter
class Item {
    private Product product;
    private int quantity;

    Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getCost() {
        return this.product.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f * %d = %.2f", product.toString(), product.getPrice(), this.getQuantity(), this.getCost());
    }
}
