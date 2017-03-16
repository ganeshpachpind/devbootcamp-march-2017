import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Project {
    @Getter
    private String name;
    @Getter
    private List<Task> tasks = new ArrayList<Task>();

    public Project(String name) {
        this.name = name;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void play(Task task) {
        task.play();
    }

    public void close(Task task, String iterationClose) {
        task.close(iterationClose);
    }
}
