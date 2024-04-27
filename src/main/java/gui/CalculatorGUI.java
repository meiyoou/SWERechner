package gui;

import javax.swing.*;
import java.awt.BorderLayout;

import operation.OperationFactory;
import operation.IOperation;

public class CalculatorGUI extends JFrame {
    DisplayManager displayManager;
    private ButtonPanel buttonPanel;
    private CalculatorController controller;
    CalculationHandler calculationHandler;

    public CalculatorGUI() {
        setTitle("Calculator App");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisierung der Komponenten
        displayManager = new DisplayManager();
        controller = new CalculatorController(this);
        buttonPanel = new ButtonPanel(controller);
        calculationHandler = new CalculationHandler(displayManager);
        
        // Layout setzen
        add(displayManager.getInputField(), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Fenster sichtbar machen
        setVisible(true);
    }

    public DisplayManager getDisplayManager() {
        return displayManager;
    }

    // Methode zur Durchführung der Berechnung
    public void performCalculation() {
        String input = displayManager.getInputField().getText();
        try {
            if (input.contains("!")) {
                calculationHandler.handleFactorial(input);
            } else if (input.contains("√")) {
                calculationHandler.handleSingleOperandOperation(input, "√");
            } else {
                String[] parts = input.split(" ");
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = parseSecondOperand(parts[2]);

                IOperation op = OperationFactory.getOperation(operator);
                double result = op.execute(num1, num2);
                displayManager.setText(String.format("%.5f", result));  // Jetzt 5 Nachkommastellen
            }
        } catch (Exception e) {
            displayManager.setText("Fehler: " + e.getMessage());
        }
    }


    double parseSecondOperand(String operand) {
        if (operand.endsWith("%")) {
            return Double.parseDouble(operand.substring(0, operand.length() - 1)) / 100.0;
        } else {
            return Double.parseDouble(operand);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
