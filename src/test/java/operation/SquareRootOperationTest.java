package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareRootOperationTest {

    @Test
    public void testExecute_positiveNumber() {
        SquareRootOperation operation = new SquareRootOperation();
        double result = operation.execute(16);
        assertEquals(4.0, result, 0.00001, "The square root of 16 should be 4.");
    }

    @Test
    public void testExecute_zero() {
        SquareRootOperation operation = new SquareRootOperation();
        double result = operation.execute(0);
        assertEquals(0.0, result, 0.00001, "The square root of 0 should be 0.");
    }

    @Test
    public void testExecute_one() {
        SquareRootOperation operation = new SquareRootOperation();
        double result = operation.execute(1);
        assertEquals(1.0, result, 0.00001, "The square root of 1 should be 1.");
    }

    @Test
    public void testExecute_negativeNumber_throwsException() {
        SquareRootOperation operation = new SquareRootOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(-1);
        }, "The square root of a negative number should throw IllegalArgumentException.");
    }

    @Test
    public void testExecute_fraction() {
        SquareRootOperation operation = new SquareRootOperation();
        double result = operation.execute(0.25);
        assertEquals(0.5, result, 0.00001, "The square root of 0.25 should be 0.5.");
    }
}
