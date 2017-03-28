import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FileOutputStreamTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void shouldBeAbleToWriteToFile() throws IOException {
        File file = testFolder.newFile("hello.txt");
        OutputStream input = new FileOutputStream(file);

        input.write("Hello, file");

        StringBuilder output = new StringBuilder();
        Files.lines(file.toPath()).forEach(output::append);

        assertThat(output.toString(), is(equalTo("Hello, file")));
    }
}
