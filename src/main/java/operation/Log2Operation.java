package operation;

public class Log2Operation implements IOperation {
    @Override
    public double execute(double... operands) {
        if (operands[0] <= 0) {
            throw new IllegalArgumentException("Log2 cannot be calculated for non-positive numbers.");
        }
        return Math.log(operands[0]) / Math.log(2);
    }
}

