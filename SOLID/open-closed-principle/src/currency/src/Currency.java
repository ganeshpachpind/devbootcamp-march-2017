import lombok.Getter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Getter
class Currency {
    final double value;
    final float factor;
    private String symbol;

    Currency(double value, float factor, String symbol) {
        this.value = value;
        this.factor = factor;
        this.symbol = symbol;
    }

    Currency add(Currency currency) {
        double convertedValue = (currency.getValue() / currency.getFactor()) * this.factor;
        return new Currency(this.value + convertedValue, this.factor, this.symbol);
    }

    Currency convertTo(Class<?> clazz) throws ConvertException {
        try {
            Constructor constructor = clazz.getDeclaredConstructor(double.class);
            Currency currency = (Currency) constructor.newInstance(1.0);
            double convertedValue = (this.value / this.factor) * currency.getFactor();
            return new Currency(convertedValue, currency.factor, currency.symbol);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new ConvertException(String.format("Conversion between %s to %s is not yet supported", this.getClass().getName(), clazz.getName()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (Double.compare(currency.getValue(), getValue()) != 0) return false;
        if (Float.compare(currency.getFactor(), getFactor()) != 0) return false;
        return getSymbol().equals(currency.getSymbol());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getValue());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getFactor() != +0.0f ? Float.floatToIntBits(getFactor()) : 0);
        result = 31 * result + getSymbol().hashCode();
        return result;
    }
}
