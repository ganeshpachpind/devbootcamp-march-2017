import lombok.Getter;


@Getter
public class Spike extends Task {

    public Spike(Integer number, String name, String description, String iteration, String pair) {
        super(number, name, description, iteration, pair);
    }
}
