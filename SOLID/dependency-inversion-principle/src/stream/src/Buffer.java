import java.io.IOException;

class Buffer {

    private InputStream inputStream;
    private OutputStream outputStream;

    private Buffer() {
    }

    Buffer(InputStream inputStream, OutputStream outputStream) {
        this();
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    void write() throws IOException {
        outputStream.write(inputStream.read());
    }
}
