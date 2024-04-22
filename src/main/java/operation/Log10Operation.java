package operation;

public class Log10Operation {
    public Log10Operation() {};

    public static double log10Of(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Log10 cannot be calculated for non-positive numbers.");
        }
        return Math.log10(number);
    }
}
