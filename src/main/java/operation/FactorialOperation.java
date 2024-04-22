package operation;

public class FactorialOperation {
    public double factorialOf(double num) {
       double result = 1;
         for (int i = 2; i <= num; i++) {
              result *= i;
         }
            return result;
    }
}
