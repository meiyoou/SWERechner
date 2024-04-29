package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalLogarithmOperationTest {

    @Test
    public void testExecute_positiveNumber() {
        NaturalLogarithmOperation operation = new NaturalLogarithmOperation();
        double result = operation.execute(Math.E); // e^1 = e
        assertEquals(1.0, result, 0.00001, "Log of e should be 1.");
    }

    @Test
    public void testExecute_one() {
        NaturalLogarithmOperation operation = new NaturalLogarithmOperation();
        double result = operation.execute(1);
        assertEquals(0.0, result, 0.00001, "Log of 1 should be 0.");
    }

    @Test
    public void testExecute_nonPositiveNumber_throwsIllegalArgumentException() {
        NaturalLogarithmOperation operation = new NaturalLogarithmOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(0);
        }, "Log of zero should throw IllegalArgumentException.");

        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(-1);
        }, "Log of negative number should throw IllegalArgumentException.");
    }
}
