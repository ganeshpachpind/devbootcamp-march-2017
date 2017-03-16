import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DollarTest {
    @Test
    public void factoryValueShouldBeDefined() {
        Dollar dollar = new Dollar(1);

        assertThat(dollar.getFactor(), is(equalTo(1.0f)));
    }

    @Test
    public void currencySymbolShouldBeDefined() {
        Dollar dollar = new Dollar(1);

        assertThat(dollar.getSymbol(), is(equalTo("USD")));
    }
}
