package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbsoluteValueOperationTest {

    @Test
    public void testExecute_positiveNumber() {
        AbsoluteValueOperation operation = new AbsoluteValueOperation();
        double result = operation.execute(10);
        assertEquals(10.0, result, "The absolute value of a positive number should be the number itself.");
    }

    @Test
    public void testExecute_negativeNumber() {
        AbsoluteValueOperation operation = new AbsoluteValueOperation();
        double result = operation.execute(-10);
        assertEquals(10.0, result, "The absolute value of a negative number should be the positive of that number.");
    }

    @Test
    public void testExecute_zero() {
        AbsoluteValueOperation operation = new AbsoluteValueOperation();
        double result = operation.execute(0);
        assertEquals(0.0, result, "The absolute value of zero should be zero.");
    }
}
