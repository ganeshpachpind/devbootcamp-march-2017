import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BufferTest {

    private class TestInputStream implements InputStream {
        private String input;

        TestInputStream(String input) {
            this.input = input;
        }

        @Override
        public String read() throws IOException {
            return input;
        }
    }

    private class TestOutputStream implements OutputStream {

        private final StringBuffer buffer;

        TestOutputStream() {
            buffer = new StringBuffer();
        }

        @Override
        public void write(String... value) throws IOException {
            Arrays.asList(value).forEach(buffer::append);
        }

        @Override
        public String toString() {
            return buffer.toString();
        }
    }

    @Test
    public void shouldBeAbleToWriteBufferToOutputStream() throws IOException {
        String input = "Hello";
        TestInputStream inputStream = new TestInputStream(input);
        OutputStream outputStream = new TestOutputStream();

        Buffer buffer = new Buffer(inputStream, outputStream);

        buffer.write();

        assertThat(outputStream.toString(), is(equalTo("Hello")));
    }
}
