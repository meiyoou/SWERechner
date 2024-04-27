package operation;

public class OperationFactory {
    public static IOperation getOperation(String operator) {
        switch (operator) {
            case "+": return new AdditionOperation();
            case "-": return new SubtractionOperation();
            case "*": return new MultiplicationOperation();
            case "/": return new DivisionOperation();
            case "^": return new ExponentiationOperation();
            case "sin": return new SinusOperation();
            case "cos": return new CosinusOperation();
            case "tan": return new TangensOperation();
            case "log": return new LogarithmOperation();
            case "ln": return new NaturalLogarithmOperation();
            case "log10": return new Log10Operation();
            case "!": return new FactorialOperation();
            case "∛": return new CubeRootOperation();
            case "√": return new SquareRootOperation(); // Stellen Sie sicher, dass dies hinzugefügt ist
            default: throw new IllegalArgumentException("Unknown operation type: " + operator);
        }
    }
}
