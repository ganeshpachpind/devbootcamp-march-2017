import lombok.Getter;

@Getter
class Rupee extends Currency {

    Rupee(double value) {
        super(value, 66, "INR");
    }
}
