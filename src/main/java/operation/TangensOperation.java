package operation;

public class TangensOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.tan(Math.toRadians(operands[0]));
    }
}
