import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class OrderTest {

    private List<Item> items;

    @Before
    public void setUp() {
        Product apple = new Product("Apple", "fruit", 250, 45.56, "gms");
        Product banana = new Product("Banana", "fruit", 250, 6.50, "gms");
        items = Arrays.asList(new Item(apple, 4), new Item(banana, 2));
    }

    @Test
    public void shouldBeAbleToCreateOrderWithMultipleItems() {
        Order order = new Order(items);

        assertThat(order.getItems(), is(equalTo(items)));
    }

    @Test
    public void shouldBeAbleToGetTotalCost() {
        Order order = new Order(items);

        assertThat(order.getTotal(), is(equalTo(195.24)));
    }
}
