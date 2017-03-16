import lombok.Getter;


@Getter
public class Story extends Task {

    private String size;

    public Story(Integer number, String name, String description, String iteration, String pair, String size) {
        super(number, name, description, iteration, pair);
        this.size = size;
    }

    @Override
    public boolean canClose(String iterationClose) {
        return (iterationClose.equals(iteration) && size.equals("small"));
    }
}
