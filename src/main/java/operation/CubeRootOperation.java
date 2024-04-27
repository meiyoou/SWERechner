package operation;

public class CubeRootOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        if (operands.length != 1) {
            throw new IllegalArgumentException("CubeRoot operation requires exactly one operand.");
        }
        return Math.cbrt(operands[0]);
    }
}
