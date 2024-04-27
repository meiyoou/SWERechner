package operation;

public class DivisionOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        if (operands[1] == 0) throw new IllegalArgumentException("Division by zero is not allowed.");
        return operands[0] / operands[1];
    }
}
