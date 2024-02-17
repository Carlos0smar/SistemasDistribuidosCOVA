import cova.assingment.firstexercise.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.desktop.OpenFilesEvent;

public class FactorialTests {
    @Test
    public void factorialTest() {

        Assertions.assertEquals(120, Operations.factorial(5));

    }
}
