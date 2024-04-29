package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialOperationTest {

    @Test
    public void testExecute_withPositiveInteger() {
        FactorialOperation operation = new FactorialOperation();
        double result = operation.execute(5);
        assertEquals(120.0, result, "The factorial of 5 should be 120.");
    }

    @Test
    public void testExecute_withZero() {
        FactorialOperation operation = new FactorialOperation();
        double result = operation.execute(0);
        assertEquals(1.0, result, "The factorial of 0 should be 1.");
    }

    @Test
    public void testExecute_withNegativeNumber() {
        FactorialOperation operation = new FactorialOperation();
        assertThrows(IllegalArgumentException.class, () -> operation.execute(-1),
                "Factorial of a negative number should throw IllegalArgumentException.");
    }

    @Test
    public void testExecute_withNonInteger() {
        FactorialOperation operation = new FactorialOperation();
        double result = operation.execute(5.5);
        assertEquals(120.0, result, "The factorial of 5.5 should be treated as the factorial of 5.");
    }

    @Test
    public void testExecute_withLargeNumber() {
        FactorialOperation operation = new FactorialOperation();
        double result = operation.execute(20);
        assertEquals(2432902008176640000.0, result, "The factorial of 20 should be correctly calculated.");
    }
}
