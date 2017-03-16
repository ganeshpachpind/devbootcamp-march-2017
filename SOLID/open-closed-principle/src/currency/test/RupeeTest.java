import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RupeeTest {

    @Test
    public void factoryValueShouldBeDefined() {
        Rupee rupee = new Rupee(1);

        assertThat(rupee.getFactor(), is(equalTo(66.0f)));
    }

    @Test
    public void currencySymbolShouldBeDefined() {
        Rupee rupee = new Rupee(1);

        assertThat(rupee.getSymbol(), is(equalTo("INR")));
    }
}
