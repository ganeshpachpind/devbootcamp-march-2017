import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StoryTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldBeAbleToCreateAStoryWithSize() {
        String size = "Medium";
        Story story = new Story(1234, "Authentication", "Authentication for user", "iteration 1", "pair", size);
        assertEquals(size, story.getSize());
    }

    @Test
    public void shouldBeAbleToCloseAStoryIfStoryIsSmallIterationStartAndIterationEndAreTheSameAnd() {

        Story story = new Story(1234, "Authentication", "Authentication for user", "i1", "pair", "small");

        story.close("i1");

        assertEquals("Has been closed in i1", systemOutRule.getLog());
    }

    @Test(expected = CannotCloseException.class)
    public void shouldNotBeAbleToCloseAStoryIfStoryIsNotSmallIterationStartAndIterationEndAreTheSameAnd() {
        Task story = new Story(1234, "Authentication", "Authentication for user", "i1", "pair", "medium");

        story.close("i1");

        assertNotEquals("Has been closed in i1", systemOutRule.getLog());
    }



}
