package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModuloOperationTest {

    @Test
    public void testExecute_withPositiveNumbers() {
        ModuloOperation operation = new ModuloOperation();
        double result = operation.execute(10, 3);
        assertEquals(1.0, result, 0.00001, "10 modulo 3 should be 1.");
    }

    @Test
    public void testExecute_withNegativeDivisor() {
        ModuloOperation operation = new ModuloOperation();
        double result = operation.execute(10, -3);
        assertEquals(1.0, result, 0.00001, "10 modulo -3 should still be 1.");
    }

    @Test
    public void testExecute_withNegativeDividend() {
        ModuloOperation operation = new ModuloOperation();
        double result = operation.execute(-10, 3);
        assertEquals(-1.0, result, 0.00001, "-10 modulo 3 should be -1.");
    }

    @Test
    public void testExecute_withZeroDivisor() {
        ModuloOperation operation = new ModuloOperation();
        assertThrows(IllegalArgumentException.class, () -> {
            operation.execute(10, 0);
        }, "Modulo by zero should throw IllegalArgumentException.");
    }

    @Test
    public void testExecute_withZeroDividend() {
        ModuloOperation operation = new ModuloOperation();
        double result = operation.execute(0, 3);
        assertEquals(0.0, result, 0.00001, "0 modulo 3 should be 0.");
    }
}
