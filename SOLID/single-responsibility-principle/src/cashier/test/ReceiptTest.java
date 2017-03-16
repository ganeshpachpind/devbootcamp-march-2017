import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReceiptTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private Order order;

    @Before
    public void setUp() throws Exception {
        Item product = new Item(new Product("Apple", "Fruit", 250, 33.33, "gms"), 10);
        Item anotherProduct = new Item(new Product("Pineapple", "Fruit", 250, 11.11, "gms"), 10);

        List<Item> items = Arrays.asList(product, anotherProduct);
        order = new Order(items);
    }

    @Test
    public void shouldBeAbleToGenerateReceiptForAnOrder() {
        String printText = new StringBuilder()
                .append("Receipt\n")
                .append("Apple Fruit 33.33 250(gms): 33.33 * 10 = 333.30\n")
                .append("Pineapple Fruit 11.11 250(gms): 11.11 * 10 = 111.10\n")
                .append("Total: 444.4")
                .toString();

        Receipt receipt = new Receipt(order);
        receipt.print();

        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), is(equalTo(printText)));
    }
}
