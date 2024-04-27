package gui;

import operation.OperationFactory;
import operation.IOperation;

public class CalculationHandler {
    private DisplayManager displayManager;

    public CalculationHandler(DisplayManager displayManager) {
        this.displayManager = displayManager;
    }

    public void handleSingleOperandOperation(String input, String operation) {
        try {
            double value;
            if (operation.equals("√")) {
                value = Double.parseDouble(input.replace("√", ""));
                value = Math.sqrt(value);
            } else {
                // Fallback for unrecognized operations
                throw new IllegalArgumentException("Unbekannte Operation: " + operation);
            }
            displayManager.setText(String.format("%.2f", value));
        } catch (NumberFormatException e) {
            displayManager.setText("Fehler: Ungültige Zahleneingabe für " + operation);
        }
    }

    public void handleSpecialFunction(String command) {
        try {
            double value = Double.parseDouble(displayManager.getInputField().getText().trim());
            IOperation operation = OperationFactory.getOperation(command);
            double result = operation.execute(value);
            displayManager.setText(String.format("%.2f", result));
        } catch (Exception e) {
            displayManager.setText("Fehler: " + e.getMessage());
        }
    }
}
