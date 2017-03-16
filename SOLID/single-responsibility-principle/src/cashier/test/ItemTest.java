import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ItemTest {

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Apple", "Fruit", 250, 45.50, "gms");
    }

    @Test
    public void shouldBeAbleToCreateItem() {
        Item item = new Item(product, 0);

        assertThat(item.getProduct(), is(equalTo(product)));
    }

    @Test
    public void shouldBeAbleToSpecifyQtyWhenCreatingItem() {
        int qty = 25;
        Item item = new Item(product, qty);

        assertThat(item.getQuantity(), is(equalTo(qty)));
    }

    @Test
    public void shouldBeAbleToGetCost() {
        Item item = new Item(product, 10);

        assertThat(item.getCost(), is(equalTo(455.0)));
    }
}
