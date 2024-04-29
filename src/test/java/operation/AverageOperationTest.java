package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AverageOperationTest {

    @Test
    public void testExecute_withMultipleNumbers() {
        AverageOperation operation = new AverageOperation();
        double result = operation.execute(1, 2, 3, 4, 5);
        assertEquals(3.0, result, "The average of 1, 2, 3, 4, 5 should be 3.");
    }

    @Test
    public void testExecute_withOneNumber() {
        AverageOperation operation = new AverageOperation();
        double result = operation.execute(5);
        assertEquals(5.0, result, "The average of a single number should be the number itself.");
    }

    @Test
    public void testExecute_withNoOperands() {
        AverageOperation operation = new AverageOperation();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operation.execute();
        });
        assertEquals("No operands provided for average calculation.", exception.getMessage(), "An exception should be thrown if no operands are provided.");
    }

    @Test
    public void testExecute_withNullOperands() {
        AverageOperation operation = new AverageOperation();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            operation.execute((double[]) null);
        });
        assertEquals("No operands provided for average calculation.", exception.getMessage(), "An exception should be thrown if null is passed as operands.");
    }

    @Test
    public void testExecute_withNegativeNumbers() {
        AverageOperation operation = new AverageOperation();
        double result = operation.execute(-1, -2, -3, -4, -5);
        assertEquals(-3.0, result, "The average of -1, -2, -3, -4, -5 should be -3.");
    }

    @Test
    public void testExecute_withMixedSignNumbers() {
        AverageOperation operation = new AverageOperation();
        double result = operation.execute(-1, 1, -2, 2, 0);
        assertEquals(0.0, result, "The average of -1, 1, -2, 2, 0 should be 0.");
    }
}
