import java.util.Arrays;

class ConsoleOutputStream implements OutputStream {

    @Override
    public void write(String... value) {
        Arrays.asList(value).forEach(System.out::print);
    }
}
