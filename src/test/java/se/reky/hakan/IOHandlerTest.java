package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class IOHandlerTest {
    @Test
    public void testReadLine() {
        String input = "Test input";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        IOHandler ioHandler = new IOHandler(scanner);

        String output = ioHandler.nextLine();
        Assertions.assertEquals(input, output);
    }
    @Test
    public void testHasNextInt() {
        // Skapa en Scanner med en siffra som en sträng
        Scanner scanner = new Scanner("123");

        // Skapa en IOHandler med den nya Scanner-instansen
        IOHandler ioHandler = createIOHandler(scanner);

        // Testa att hasNextInt() returnerar true eftersom Scanner är instansierad med en siffra
        Assertions.assertTrue(ioHandler.hasNextInt());
    }

    private IOHandler createIOHandler(Scanner scanner) {
        return new IOHandler(scanner);
    }
}

