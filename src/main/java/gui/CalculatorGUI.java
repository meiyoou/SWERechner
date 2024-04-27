package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import operation.OperationFactory;
import operation.IOperation;

public class CalculatorGUI extends JFrame {
    private DisplayManager displayManager;
    private ButtonPanel buttonPanel;
    private CalculatorController controller;

    public CalculatorGUI() {
        setTitle("Calculator App");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisierung der Komponenten
        displayManager = new DisplayManager();
        controller = new CalculatorController(this);
        buttonPanel = new ButtonPanel(controller);

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
            String[] parts = input.split(" ");
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);
            IOperation op = OperationFactory.getOperation(operator);
            double result = op.execute(num1, num2);
            displayManager.setText(String.format("%.2f", result));
        } catch (Exception e) {
            displayManager.setText("Fehler: " + e.getMessage());
        }
    }

    // Methode zur Verarbeitung spezieller Funktionen
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
