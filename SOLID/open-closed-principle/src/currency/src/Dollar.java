import lombok.Getter;

@Getter
class Dollar extends Currency {

    Dollar(double value) {
        super(value, 1.0f, "USD");
    }
}
