package operation;

public class LogarithmOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.log(operands[0]);
    }
}
