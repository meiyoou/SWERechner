package operation;

import java.util.List;

public class AverageOperation { // This class is used to calculate the average of a list of numbers; Zahlen mithilfe von ; abtrennen
    public static double averageOf(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be null or empty");
        }
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
}
