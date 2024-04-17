package operation;

public class Log2Operation {
    public Log2Operation() {};

    public static double log2Of(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Log2 cannot be calculated for non-positive numbers.");
        }
        return Math.log(number) / Math.log(2);
    }
}
