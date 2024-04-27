package operation;

public class FactorialOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        double result = 1;
        int num = (int) operands[0];
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
