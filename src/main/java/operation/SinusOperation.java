package operation;

public class SinusOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.sin(Math.toRadians(operands[0]));
    }
}

