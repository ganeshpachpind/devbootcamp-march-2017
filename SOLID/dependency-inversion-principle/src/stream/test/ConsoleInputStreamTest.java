import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ConsoleInputStreamTest {

    @Rule
    public final TextFromStandardInputStream inputStream = emptyStandardInputStream();

    @Test
    public void shouldReadInputFromConsole() throws IOException {
        String input = "Hello";
        InputStream console = new ConsoleInputStream();

        inputStream.provideLines(input);
        String value = console.read();

        assertThat(value, is(equalTo(input)));
    }
}
