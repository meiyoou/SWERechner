package operation;

public class RoundingOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.round(operands[0]);
    }
}
