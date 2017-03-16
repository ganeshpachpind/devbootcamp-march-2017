import lombok.Getter;

import java.util.List;

@Getter
class Order {
    private List<Item> items;

    Order(List<Item> items) {
        this.items = items;
    }

    double getTotal() {
        return items.stream().map(Item::getCost).reduce(0.00, (total, cost) -> total + cost);
    }
}
