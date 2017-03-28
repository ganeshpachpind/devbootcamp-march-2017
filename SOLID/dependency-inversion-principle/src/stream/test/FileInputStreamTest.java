import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FileInputStreamTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void shouldReadInputFromFile() throws IOException {
        List<String> lines = Arrays.asList("Hello,", " file");
        File file = testFolder.newFile("hello.txt");
        Files.write(file.toPath(), lines);

        InputStream input = new FileInputStream(file);

        String value = input.read();
        assertThat(value, is(equalTo("Hello, file")));
    }
}
