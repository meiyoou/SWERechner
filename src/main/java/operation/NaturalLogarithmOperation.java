package operation;

public class NaturalLogarithmOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.log(operands[0]);
    }
}
