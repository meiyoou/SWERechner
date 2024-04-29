package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExponentiationOperationTest {

    @Test
    public void testExecute_positiveExponents() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(2, 3);
        assertEquals(8.0, result, 0.00001, "2 raised to the power of 3 should be 8.");
    }

    @Test
    public void testExecute_zeroExponent() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(2, 0);
        assertEquals(1.0, result, 0.00001, "Any number raised to the power of 0 should be 1.");
    }

    @Test
    public void testExecute_negativeExponent() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(2, -1);
        assertEquals(0.5, result, 0.00001, "2 raised to the power of -1 should be 0.5.");
    }

    @Test
    public void testExecute_fractionalBase() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(0.5, 2);
        assertEquals(0.25, result, 0.00001, "0.5 raised to the power of 2 should be 0.25.");
    }

    @Test
    public void testExecute_zeroBasePositiveExponent() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(0, 5);
        assertEquals(0.0, result, 0.00001, "0 raised to any positive power should be 0.");
    }

    @Test
    public void testExecute_zeroBaseNegativeExponent() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(0, -1);
        assertEquals(Double.POSITIVE_INFINITY, result, "0 raised to any negative power should be positive infinity.");
    }

    @Test
    public void testExecute_zeroBaseZeroExponent() {
        ExponentiationOperation operation = new ExponentiationOperation();
        double result = operation.execute(0, 0);
        assertEquals(1.0, result, 0.00001, "0 raised to the power of 0 should be 1 (mathematically undefined but commonly defined as 1).");
    }
}
