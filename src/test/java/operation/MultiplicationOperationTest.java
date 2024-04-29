package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationOperationTest {

    @Test
    public void testExecute_withPositiveNumbers() {
        MultiplicationOperation operation = new MultiplicationOperation();
        double result = operation.execute(5, 4);
        assertEquals(20.0, result, 0.00001, "Multiplying 5 by 4 should yield 20.");
    }

    @Test
    public void testExecute_withNegativeAndPositiveNumber() {
        MultiplicationOperation operation = new MultiplicationOperation();
        double result = operation.execute(-5, 4);
        assertEquals(-20.0, result, 0.00001, "Multiplying -5 by 4 should yield -20.");
    }

    @Test
    public void testExecute_withNegativeNumbers() {
        MultiplicationOperation operation = new MultiplicationOperation();
        double result = operation.execute(-5, -4);
        assertEquals(20.0, result, 0.00001, "Multiplying -5 by -4 should yield 20.");
    }

    @Test
    public void testExecute_withZero() {
        MultiplicationOperation operation = new MultiplicationOperation();
        double result = operation.execute(5, 0);
        assertEquals(0.0, result, 0.00001, "Multiplying any number by 0 should yield 0.");
        result = operation.execute(0, 10);
        assertEquals(0.0, result, 0.00001, "Multiplying 0 by any number should also yield 0.");
    }

    @Test
    public void testExecute_withOne() {
        MultiplicationOperation operation = new MultiplicationOperation();
        double result = operation.execute(5, 1);
        assertEquals(5.0, result, 0.00001, "Multiplying any number by 1 should yield the number itself.");
    }
}
