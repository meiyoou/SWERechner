package operation;

public class AdditionOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return operands[0] + operands[1];
    }
}

