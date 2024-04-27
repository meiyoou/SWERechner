package operation;

import java.util.Arrays;

public class AverageOperation implements IOperation {
    @Override
    public double execute(double... operands) {
        if (operands == null || operands.length == 0) {
            throw new IllegalArgumentException("No operands provided for average calculation.");
        }
        return Arrays.stream(operands).average().orElseThrow(() ->
                new IllegalArgumentException("Error calculating average"));
    }
}
