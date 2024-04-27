package operation;

public class Log10Operation implements IOperation {
    @Override
    public double execute(double... operands) {
        if (operands[0] <= 0) {
            throw new IllegalArgumentException("Log10 cannot be calculated for non-positive numbers.");
        }
        return Math.log10(operands[0]);
    }
}

