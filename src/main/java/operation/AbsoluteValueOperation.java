package operation;

public class AbsoluteValueOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.abs(operands[0]);
    }
}

