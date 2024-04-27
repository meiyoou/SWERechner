package operation;

public class CosinusOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        return Math.cos(Math.toRadians(operands[0]));
    }
}


