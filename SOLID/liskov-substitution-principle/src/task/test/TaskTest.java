import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldBeAbleToCreateATaskWithNumber() {
        Integer number = 1234;
        Task story = new Task(number, "Authentication", "Authentication for user", "iteration 1", "pair");
        assertEquals(number, story.getNumber());
    }

    @Test
    public void shouldBeAbleToCreateATaskWithName() {
        String name = "Authentication";
        Task story = new Task(123, name, null, "iteration 1", "pair");
        assertEquals(name, story.getName());
    }

    @Test
    public void shouldBeAbleToCreateATaskWithDescription() {
        String description = "As a user, I should be able to login to system with username and password";
        Task story = new Task(1234, "Authentication", description, null, null);
        assertEquals(description, story.getDescription());
    }

    @Test
    public void shouldBeAbleToCreateATaskToBePlayedInAGivenIteration() {
        String iteration = "iteration 1";
        Task story = new Task(1234, "Authentication", null, iteration, null);
        assertEquals(iteration, story.getIteration());
    }

    @Test
    public void shouldBeAbleToCreateATaskBeingPlayedByTheSpecifiedPair() {
        String pair = "Krishna/Nithya";
        Task story = new Task(132, "Authentication", null, null, pair);
        assertEquals(pair, story.getPair());
    }

    @Test
    public void shouldPrintMessageIfStoryHasBeenPlayed() {
        Task task = new Task(141, "Playable Task", null, null, null);

        task.play();

        assertEquals("Has been played", systemOutRule.getLog());
    }

    @Test
    public void shouldBeAbleToCloseATaskIfCanCloseReturnsTrue(){
        Task task = new Task(142, "Some Random Task", null, "i8", null);

        task.close("i8");

        assertEquals("Has been closed in i8", systemOutRule.getLog());
    }

}
