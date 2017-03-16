import lombok.Getter;

@Getter
public class Task {
    protected Integer number;
    protected String name;
    protected String description;
    protected String iteration;
    protected String pair;

    public Task(Integer number, String name, String description, String iteration, String pair) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.iteration = iteration;
        this.pair = pair;
    }

    public void play() {
        System.out.print("Has been played");
    }

    public void close(String iterationClose) {
        if (!canClose(iterationClose))
            throw new CannotCloseException("Cannot be closed!");
        System.out.print("Has been closed in " + iterationClose);
    }

    public boolean canClose(String iterationClose) {
        return true;
    }
}
