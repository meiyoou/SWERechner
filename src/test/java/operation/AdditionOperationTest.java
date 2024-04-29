package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionOperationTest {

    @Test
    public void testExecute_withPositiveNumbers() {
        AdditionOperation operation = new AdditionOperation();
        double result = operation.execute(5, 3);
        assertEquals(8.0, result, "Adding two positive numbers should return the correct sum.");
    }

    @Test
    public void testExecute_withNegativeNumbers() {
        AdditionOperation operation = new AdditionOperation();
        double result = operation.execute(-5, -3);
        assertEquals(-8.0, result, "Adding two negative numbers should return the correct sum.");
    }

    @Test
    public void testExecute_withPositiveAndNegativeNumber() {
        AdditionOperation operation = new AdditionOperation();
        double result = operation.execute(5, -3);
        assertEquals(2.0, result, "Adding a positive number and a negative number should return the correct sum.");
    }

    @Test
    public void testExecute_withZero() {
        AdditionOperation operation = new AdditionOperation();
        double result = operation.execute(0, 0);
        assertEquals(0.0, result, "Adding zero to zero should return zero.");
    }

    @Test
    public void testExecute_withLargeNumbers() {
        AdditionOperation operation = new AdditionOperation();
        double result = operation.execute(1000000, 500000);
        assertEquals(1500000.0, result, "Adding large numbers should return the correct sum.");
    }
}
