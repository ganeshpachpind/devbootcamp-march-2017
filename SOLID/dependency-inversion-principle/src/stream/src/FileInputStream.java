import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class FileInputStream implements InputStream {
    private File file;

    FileInputStream(File file) {
        this.file = file;
    }

    @Override
    public String read() throws IOException {
        StringBuilder output = new StringBuilder();

        Files.lines(file.toPath()).forEach(output::append);
        return output.toString();
    }
}
