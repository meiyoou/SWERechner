package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundingOperationTest {

    @Test
    public void testExecute_roundPositive() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(3.5);
        assertEquals(4.0, result, "Rounding 3.5 should yield 4.");
    }

    @Test
    public void testExecute_roundNegative() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(-3.5);
        assertEquals(-3.0, result, "Rounding -3.5 should yield -3 (round half up).");
    }

    @Test
    public void testExecute_noRoundingNeeded() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(2.0);
        assertEquals(2.0, result, "Rounding 2.0 should yield 2.");
    }

    @Test
    public void testExecute_roundDown() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(3.2);
        assertEquals(3.0, result, "Rounding 3.2 should yield 3.");
    }

    @Test
    public void testExecute_roundUp() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(3.7);
        assertEquals(4.0, result, "Rounding 3.7 should yield 4.");
    }

    @Test
    public void testExecute_roundHalfEven() {
        RoundingOperation operation = new RoundingOperation();
        double result = operation.execute(4.5);
        assertEquals(5.0, result, "Rounding 4.5 should follow round half even rule and yield 5.");
    }
}
