import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConsoleOutputStreamTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldBeAbleToWriteToConsole() throws IOException {
        OutputStream consoleOutputStream = new ConsoleOutputStream();

        String value = "Hello";
        consoleOutputStream.write(value);

        assertThat(systemOutRule.getLogWithNormalizedLineSeparator(), is(equalTo(value)));
    }
}
