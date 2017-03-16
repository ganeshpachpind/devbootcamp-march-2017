import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class BitCoin extends Currency {
    BitCoin(double value) {
        super(value, 0.5f, "BitCoin");
    }
}

class Litecoin extends Currency {
    public Litecoin(double value) {
        super(value, 0.25f, "Litecoin");
    }
}

public class CurrencyTest {
    @Test
    public void shouldBeAbleToCreateCurrencyWithSomeValue() {
        Currency currency = new Currency(12.12, 1, "USD");

        assertThat(currency.getValue(), is(equalTo(12.12)));
    }

    @Test
    public void shouldBeAbleToAddTwoDifferentCurrency() {
        Currency dollar = new Currency(10, 1, "USD");
        Currency rupee = new Currency(660, 66, "INR");

        Currency result = dollar.add(rupee);

        assertThat(result.getValue(), is(equalTo(20.0)));
        assertThat(result.getSymbol(), is(equalTo("USD")));
        assertThat(result.getFactor(), is(equalTo(1.0f)));
    }

    @Test
    public void shouldBeAbleToConvertToDifferentCurrency() throws ConvertException {
        BitCoin bitCoin = new BitCoin(10);
        Currency currency = bitCoin.convertTo(Litecoin.class);

        assertThat(currency.getValue(), is(equalTo(5.0)));
        assertThat(currency.getSymbol(), is(equalTo("Litecoin")));
        assertThat(currency.getFactor(), is(equalTo(0.25f)));
    }

    @Test(expected = ConvertException.class)
    public void shouldThrowConvertExceptionIfDestinationTypeisNotSupported() {
        BitCoin bitCoin = new BitCoin(10);

        bitCoin.convertTo(String.class);
    }

    @Test
    public void TenBitCoinShouldBeEqualToFiveBitCoinPlusAnotherFiveBitCoin() {
        BitCoin fiveBitCoin = new BitCoin(5);
        BitCoin anotherFiveBitCoin = new BitCoin(5);

        Currency result = fiveBitCoin.add(anotherFiveBitCoin);

        assertEquals(result, new BitCoin(10));
    }
}
