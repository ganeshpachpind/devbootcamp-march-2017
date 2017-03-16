import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProjectTest {

    Project project;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        project = new Project("Big Basket");
    }

    @Test
    public void shouldBeAbleToCreateAProjectWithName() {
        assertEquals("Big Basket", project.getName());
    }

    @Test
    public void shouldBeAbleToAddAStoryToAProject() {
        Story story = new Story(121, "Add Groceries", null, null, null, null);
        project.add(story);

        List<Task> tasks = project.getTasks();
        assertEquals(story, tasks.get(0));
    }

    @Test
    public void shouldBeAbleToAddABugToAProject() {
        Bug bug = new Bug(131, "Unable to add veggies to shopping card", null, "i2", "Charlie");
        project.add(bug);

        List<Task> tasks = project.getTasks();
        assertEquals(bug, tasks.get(0));
    }

    @Test
    public void shouldBeAbleToAddASpikeToAProject() {
        Task spike = new Spike(161, "Spike to check if oauth can be supported", null, "i0", "Gowthami");
        project.add(spike);

        List<Task> tasks = project.getTasks();
        assertEquals(spike, tasks.get(0));
    }

    @Test
    public void shouldBeAbleToAddMultipleTasksToAProject() {
        Task story = new Story(161, "Awesome story", null, null, null, null);
        Task bug = new Bug(162, "Feeling sad", null, null, null);
        Task spike = new Spike(163, "I hope it's feasible", null, null, null);

        project.add(story);
        project.add(bug);
        project.add(spike);

        List<Task> tasks = project.getTasks();

        assertEquals(story, tasks.get(0));
        assertEquals(bug, tasks.get(1));
        assertEquals(spike, tasks.get(2));
    }


    @Test
    public void shouldBeAbleToPlayAStoryInAProject() {
        Task story = new Story(151, "Playable Story", null, null, null, null);

        project.play(story);

        assertEquals("Has been played", systemOutRule.getLog());
    }

    @Test
    public void shouldBeAbleToPlayABugInAProject() {
        Task bug = new Bug(464, "Fixable bug", null, null, null);

        project.play(bug);

        assertEquals("Has been played", systemOutRule.getLog());
    }

    @Test
    public void shouldBeAbleToPlayASpikeInAProject() {
        Task spike = new Spike(464, "Spikable spike", null, null, null);

        project.play(spike);

        assertEquals("Has been played", systemOutRule.getLog());
    }

    @Test
    public void shouldBeAbleToCloseAStoryOnlyIfTheIterationStartAndCloseAreSameAndSizeIsSmall() {
        Task story = new Story(151, "Closable Story", null, "i4", null, "small");

        project.close(story, "i4");

        assertEquals("Has been closed in i4", systemOutRule.getLog());
    }

    @Test(expected = CannotCloseException.class)
    public void shouldNotAbleToCloseAStoryIfTheIterationStartAndSameAreSameButSizeIsNotSmall() {
        Task story = new Story(151, "Big Story", null, "i4", null, "medium");

        project.close(story, "i4");

    }

    @Test
    public void shouldBeAbleToCloseABug() {
        Task bug = new Bug(152, "Closable Bug", null, null, null);

        project.close(bug, "i5");

        assertEquals("Has been closed in i5", systemOutRule.getLog());
    }

    @Test
    public void shouldBeAbleToCloseASpike() {
        Task spike = new Spike(152, "Closable Spike", null, null, null);

        project.close(spike, "i6");

        assertEquals("Has been closed in i6", systemOutRule.getLog());
    }


}
