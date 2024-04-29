package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationFactoryTest {

    @Test
    public void testGetOperation_addition() {
        assertTrue(OperationFactory.getOperation("+") instanceof AdditionOperation, "Should return an instance of AdditionOperation.");
    }

    @Test
    public void testGetOperation_subtraction() {
        assertTrue(OperationFactory.getOperation("-") instanceof SubtractionOperation, "Should return an instance of SubtractionOperation.");
    }

    @Test
    public void testGetOperation_multiplication() {
        assertTrue(OperationFactory.getOperation("*") instanceof MultiplicationOperation, "Should return an instance of MultiplicationOperation.");
    }

    @Test
    public void testGetOperation_division() {
        assertTrue(OperationFactory.getOperation("/") instanceof DivisionOperation, "Should return an instance of DivisionOperation.");
    }

    @Test
    public void testGetOperation_exponentiation() {
        assertTrue(OperationFactory.getOperation("^") instanceof ExponentiationOperation, "Should return an instance of ExponentiationOperation.");
    }

    @Test
    public void testGetOperation_sinus() {
        assertTrue(OperationFactory.getOperation("sin") instanceof SinusOperation, "Should return an instance of SinusOperation.");
    }

    @Test
    public void testGetOperation_cosinus() {
        assertTrue(OperationFactory.getOperation("cos") instanceof CosinusOperation, "Should return an instance of CosinusOperation.");
    }

    @Test
    public void testGetOperation_tangens() {
        assertTrue(OperationFactory.getOperation("tan") instanceof TangensOperation, "Should return an instance of TangensOperation.");
    }

    @Test
    public void testGetOperation_logarithm() {
        assertTrue(OperationFactory.getOperation("log") instanceof LogarithmOperation, "Should return an instance of LogarithmOperation.");
    }

    @Test
    public void testGetOperation_naturalLogarithm() {
        assertTrue(OperationFactory.getOperation("ln") instanceof NaturalLogarithmOperation, "Should return an instance of NaturalLogarithmOperation.");
    }

    @Test
    public void testGetOperation_log10() {
        assertTrue(OperationFactory.getOperation("log10") instanceof Log10Operation, "Should return an instance of Log10Operation.");
    }

    @Test
    public void testGetOperation_factorial() {
        assertTrue(OperationFactory.getOperation("!") instanceof FactorialOperation, "Should return an instance of FactorialOperation.");
    }

    @Test
    public void testGetOperation_cubeRoot() {
        assertTrue(OperationFactory.getOperation("∛") instanceof CubeRootOperation, "Should return an instance of CubeRootOperation.");
    }

    @Test
    public void testGetOperation_squareRoot() {
        assertTrue(OperationFactory.getOperation("√") instanceof SquareRootOperation, "Should return an instance of SquareRootOperation.");
    }

    @Test
    public void testGetOperation_unknownOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationFactory.getOperation("unknown");
        }, "Should throw IllegalArgumentException for unknown operations.");
    }
}
