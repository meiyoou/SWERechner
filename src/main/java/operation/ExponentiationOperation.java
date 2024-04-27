package operation;

public class ExponentiationOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.pow(operands[0], operands[1]);
    }
}
