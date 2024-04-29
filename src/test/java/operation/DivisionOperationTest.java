package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionOperationTest {

    @Test
    public void testExecute_normalDivision() {
        DivisionOperation operation = new DivisionOperation();
        double result = operation.execute(10, 2);
        assertEquals(5.0, result, 0.00001, "10 divided by 2 should be 5.");
    }

    @Test
    public void testExecute_divideByOne() {
        DivisionOperation operation = new DivisionOperation();
        double result = operation.execute(10, 1);
        assertEquals(10.0, result, 0.00001, "10 divided by 1 should still be 10.");
    }

    @Test
    public void testExecute_divideByZero() {
        DivisionOperation operation = new DivisionOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(10, 0);
        }, "Division by zero should throw an IllegalArgumentException.");
    }

    @Test
    public void testExecute_negativeDivision() {
        DivisionOperation operation = new DivisionOperation();
        double result = operation.execute(10, -2);
        assertEquals(-5.0, result, 0.00001, "10 divided by -2 should be -5.");
    }

    @Test
    public void testExecute_fractionResult() {
        DivisionOperation operation = new DivisionOperation();
        double result = operation.execute(1, 2);
        assertEquals(0.5, result, 0.00001, "1 divided by 2 should be 0.5.");
    }
}
