package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOperationTest {

    // Eine fiktive Implementierung des IOperation Interfaces für Testzwecke
    private static class MockOperation implements IOperation {
        @Override
        public double execute(double... operands) {
            double sum = 0;
            for (double operand : operands) {
                sum += operand;
            }
            return sum; // Gibt die Summe der Operanden zurück
        }
    }

    @Test
    public void testExecute() {
        IOperation operation = new MockOperation();
        double result = operation.execute(1, 2, 3, 4, 5);
        assertEquals(15, result, "Should return the sum of the operands.");
    }

    @Test
    public void testExecute_singleOperand() {
        IOperation operation = new MockOperation();
        double result = operation.execute(5);
        assertEquals(5, result, "Should return the operand itself when only one is provided.");
    }

    @Test
    public void testExecute_noOperands() {
        IOperation operation = new MockOperation();
        double result = operation.execute();
        assertEquals(0, result, "Should return 0 when no operands are provided.");
    }
}
