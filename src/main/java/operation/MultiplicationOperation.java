package operation;

public class MultiplicationOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return operands[0] * operands[1];
    }
}
