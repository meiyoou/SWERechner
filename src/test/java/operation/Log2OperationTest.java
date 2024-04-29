package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log2OperationTest {

    @Test
    public void testExecute_positiveNumber() {
        Log2Operation operation = new Log2Operation();
        double result = operation.execute(8);
        assertEquals(3.0, result, 0.00001, "Log2 of 8 should be 3.");
    }

    @Test
    public void testExecute_positiveFraction() {
        Log2Operation operation = new Log2Operation();
        double result = operation.execute(0.5);
        assertEquals(-1.0, result, 0.00001, "Log2 of 0.5 should be -1.");
    }

    @Test
    public void testExecute_one() {
        Log2Operation operation = new Log2Operation();
        double result = operation.execute(1);
        assertEquals(0.0, result, 0.00001, "Log2 of 1 should be 0.");
    }

    @Test
    public void testExecute_nonPositiveNumber_throwsIllegalArgumentException() {
        Log2Operation operation = new Log2Operation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(0);
        }, "Log2 cannot be calculated for zero.");

        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(-1);
        }, "Log2 cannot be calculated for negative numbers.");
    }
}
