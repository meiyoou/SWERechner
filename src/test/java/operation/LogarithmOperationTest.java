package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogarithmOperationTest {

    @Test
    public void testExecute_positiveNumber() {
        LogarithmOperation operation = new LogarithmOperation();
        double result = operation.execute(Math.exp(1)); // e^1 = e
        assertEquals(1.0, result, 0.00001, "Log of e should be 1.");
    }

    @Test
    public void testExecute_one() {
        LogarithmOperation operation = new LogarithmOperation();
        double result = operation.execute(1);
        assertEquals(0.0, result, 0.00001, "Log of 1 should be 0.");
    }

    @Test
    public void testExecute_nonPositiveNumber_throwsIllegalArgumentException() {
        LogarithmOperation operation = new LogarithmOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(0);
        }, "Log of zero should throw IllegalArgumentException.");

        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(-1);
        }, "Log of negative number should throw IllegalArgumentException.");
    }
}
