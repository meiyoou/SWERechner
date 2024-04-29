package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CubeRootOperationTest {

    @Test
    public void testExecute_positiveNumber() {
        CubeRootOperation operation = new CubeRootOperation();
        double result = operation.execute(27);
        assertEquals(3.0, result, 0.00001, "The cube root of 27 should be 3.");
    }

    @Test
    public void testExecute_negativeNumber() {
        CubeRootOperation operation = new CubeRootOperation();
        double result = operation.execute(-27);
        assertEquals(-3.0, result, 0.00001, "The cube root of -27 should be -3.");
    }

    @Test
    public void testExecute_zero() {
        CubeRootOperation operation = new CubeRootOperation();
        double result = operation.execute(0);
        assertEquals(0.0, result, 0.00001, "The cube root of 0 should be 0.");
    }

    @Test
    public void testExecute_fraction() {
        CubeRootOperation operation = new CubeRootOperation();
        double result = operation.execute(1.0/27);
        assertEquals(1.0/3, result, 0.00001, "The cube root of 1/27 should be 1/3.");
    }

    @Test
    public void testExecute_requiresExactlyOneOperand() {
        CubeRootOperation operation = new CubeRootOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(1, 2);
        }, "CubeRoot operation requires exactly one operand.");
    }
}
