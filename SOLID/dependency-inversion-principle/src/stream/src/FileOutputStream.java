import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

class FileOutputStream implements OutputStream {
    private File file;

    FileOutputStream(File file) {
        this.file = file;
    }

    @Override
    public void write(String... value) throws IOException {
        List<String> lines = Arrays.asList(value);
        Files.write(file.toPath(), lines);
    }
}
