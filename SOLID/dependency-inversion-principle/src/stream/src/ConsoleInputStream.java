import java.util.Scanner;

class ConsoleInputStream implements InputStream {

    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
