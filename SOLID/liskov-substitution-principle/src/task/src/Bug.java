import lombok.Getter;


@Getter
public class Bug extends Task {

    public Bug(Integer number, String name, String description, String iteration, String pair) {
        super(number, name, description, iteration, pair);
    }
}
