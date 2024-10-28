import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallOrderTest {
    @Test
    public void testCallOrder() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {

            new CallOrder.Child();

            String[] outputLines = outContent.toString().split(System.lineSeparator());


            List<String> expectedOrder = List.of(
                    "1. Parent static section",
                    "2. Child static section",
                    "3. Parent constructor",
                    "4. Overridden parent method",
                    "5. Child constructor"
            );

            for (int i = 0; i < expectedOrder.size(); i++) {
                assertEquals(expectedOrder.get(i), outputLines[i]);
            }
        } finally {
            System.setOut(originalOut);
        }
    }
}
