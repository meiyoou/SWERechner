package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log10OperationTest {

    @Test
    public void testExecute_positiveNumber() {
        Log10Operation operation = new Log10Operation();
        double result = operation.execute(10);
        assertEquals(1.0, result, 0.00001, "Log10 of 10 should be 1.");
    }

    @Test
    public void testExecute_positiveFraction() {
        Log10Operation operation = new Log10Operation();
        double result = operation.execute(0.1);
        assertEquals(-1.0, result, 0.00001, "Log10 of 0.1 should be -1.");
    }

    @Test
    public void testExecute_one() {
        Log10Operation operation = new Log10Operation();
        double result = operation.execute(1);
        assertEquals(0.0, result, 0.00001, "Log10 of 1 should be 0.");
    }

    @Test
    public void testExecute_nonPositiveNumber_throwsIllegalArgumentException() {
        Log10Operation operation = new Log10Operation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(0);
        }, "Log10 cannot be calculated for zero.");

        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(-1);
        }, "Log10 cannot be calculated for negative numbers.");
    }
}
