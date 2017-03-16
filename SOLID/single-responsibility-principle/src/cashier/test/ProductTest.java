import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProductTest {

    @Test
    public void shouldBeAbleToSpecifyNameForAProduct() {
        String name = "Apple";
        Product product = new Product(name, null, 0, 0, null);

        assertThat(product.getName(), is(equalTo(name)));
    }

    @Test
    public void shouldBeAbleToSpecifyDescription() {
        String description = "the round fruit of a tree of the rose family, which typically has thin green or red skin and crisp flesh";
        Product product = new Product("Apple", description, 0, 0, null);

        assertThat(product.getDescription(), is(equalTo(description)));
    }

    @Test
    public void shouldBeAbleToSpecifyMeasure() {
        int measure = 250;
        Product product = new Product("Apple", "Fruit", measure, 0, null);

        assertThat(product.getMeasure(), is(equalTo(measure)));
    }

    @Test
    public void shouldBeAbleToSpecifyPrice() {
        double price = 45.23;
        Product product = new Product("Apple", "Fruit", 250, price, null);

        assertThat(product.getPrice(), is(equalTo(price)));
    }

    @Test
    public void shouldBeAbleToSpecifyUnit() {
        String unit = "gms";
        Product product = new Product("Apple", "Fruit", 250, 45.23, unit);

        assertThat(product.getUnit(), is(equalTo(unit)));
    }
}
