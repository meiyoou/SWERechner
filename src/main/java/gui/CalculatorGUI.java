package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import operation.OperationFactory;
import operation.IOperation;

public class CalculatorGUI extends JFrame {
    private DisplayManager displayManager;
    private ButtonPanel buttonPanel;
    private CalculatorController controller;
    private CalculationHandler calculationHandler;


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
            // Check for square root or factorial at the start or end
            if (input.contains("√")) {
                calculationHandler.handleSingleOperandOperation(input, "√");
            } else {
                // Normal calculation process
                String[] parts = input.split(" ");
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2;

                if (parts[2].endsWith("%")) {
                    String percentString = parts[2].substring(0, parts[2].length() - 1);
                    num2 = Double.parseDouble(percentString) / 100.0;
                } else {
                    num2 = Double.parseDouble(parts[2]);
                }

                IOperation op = OperationFactory.getOperation(operator);
                double result = op.execute(num1, num2);
                displayManager.setText(String.format("%.2f", result));
            }
        } catch (Exception e) {
            displayManager.setText("Fehler: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
