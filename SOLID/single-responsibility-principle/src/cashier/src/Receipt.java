import lombok.Getter;

@Getter
class Receipt {
    private Order order;

    Receipt(Order order) {
        this.order = order;
    }

    void print() {
        System.out.println("Receipt");
        order.getItems().forEach(item -> System.out.println(item.toString()));
        System.out.format("Total: %s", order.getTotal());
    }
}
