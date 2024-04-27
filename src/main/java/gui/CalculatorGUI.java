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
            // Entfernen von zusätzlichen Leerzeichen und Aufteilen der Eingabe
            String[] parts = input.split(" ");

            // Variablen zur Speicherung der Operanden und des Operators
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2;

            // Überprüfen, ob der zweite Operand ein Prozentwert ist
            if (parts[2].endsWith("%")) {
                // Entfernen des Prozentzeichens und Umrechnen in eine Dezimalzahl
                String percentString = parts[2].substring(0, parts[2].length() - 1);
                num2 = Double.parseDouble(percentString) / 100.0;
            } else {
                num2 = Double.parseDouble(parts[2]);
            }

            // Holen der Operation von der Factory und Ausführen der Berechnung
            IOperation op = OperationFactory.getOperation(operator);
            double result = op.execute(num1, num2);

            // Setzen des Ergebnisses im Display
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
