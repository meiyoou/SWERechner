package operation;

public class SquareRootOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.sqrt(operands[0]);
    }
}
