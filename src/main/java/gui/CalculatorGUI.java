package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import operation.IOperation;
import operation.OperationFactory;
import java.util.Arrays;

public class CalculatorGUI extends JFrame {
    private DisplayManager displayManager;
    private ButtonPanel buttonPanel;
    private ActionManager actionManager;

    public CalculatorGUI() {
        setTitle("Calculator App");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayManager = new DisplayManager();
        actionManager = new ActionManager(this);
        buttonPanel = new ButtonPanel(actionManager);

        add(displayManager.getInputField(), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void processAction(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            displayManager.setText(displayManager.getInputField().getText() + command);
            return;
        } else if ("C".equals(command)) {
            displayManager.setText("");
        } else if ("=".equals(command)) {
            if (displayManager.getInputField().getText().contains("!")) {
                calculateSingleOperandOperation("!");
            }else if (displayManager.getInputField().getText().contains("%")) {
                calculatePercentage();
            } else if (displayManager.getInputField().getText().startsWith("√")) {
                calculateSingleOperandOperation("√");
            } else {
                performOperation();
            }
        } else if ("+-*/^".contains(command)) {
            displayManager.setText(displayManager.getInputField().getText() + " " + command + " ");
        }else if (command.equals("%")) {
            displayManager.setText(displayManager.getInputField().getText() + " " + command);
        } else if (command.equals("!")) {
            displayManager.setText(displayManager.getInputField().getText() + command);
        }else if (command.equals("√")) {
            // Hier könnten Sie direkt die Quadratwurzel verarbeiten, ohne dass der Benutzer '=' drücken muss
            calculateSingleOperandOperation(command);
        } else {
            switch (command) {
                case "sin":
                case "cos":
                case "tan":
                case "log":
                case "ln":
                case "log10":
                case "∛":
                    displayManager.setText(displayManager.getInputField().getText());
                    calculateSingleOperandOperation(command);
                    break;
                default:
                    displayManager.setText("Unbekannter Befehl");
                    break;
            }
        }
    }


    private void calculatePercentage() {
        String input = displayManager.getInputField().getText().trim();
        String[] parts = input.split(" ");
        if (parts.length < 3) {
            displayManager.setText("Unvollständige Eingabe!");
            return;
        }
        try {
            double base = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double percent = Double.parseDouble(parts[2].replace("%", "")); // Entfernt das Prozentzeichen

            double result = 0;
            if (operator.equals("+")) {
                result = base + (base * percent / 100);
            } else if (operator.equals("-")) {
                result = base - (base * percent / 100);
            } else if (operator.equals("*")) {
                result = base * (percent / 100);
            } else if (operator.equals("/")) {
                result = base / (percent / 100);
            }

            displayManager.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            displayManager.setText("Fehler bei der Zahleneingabe!");
        } catch (IllegalArgumentException e) {
            displayManager.setText(e.getMessage());
        }
    }

    private void calculateSingleOperandOperation(String operation) {
        String input = displayManager.getInputField().getText().trim();
        if (operation.equals("!")) {
            input = input.replace("!", ""); // Entfernen des Ausrufezeichens
        }
        if (operation.equals("√") && input.isEmpty()) { // Wenn keine Zahl vor √ steht, zeigen Sie Fehler
            displayManager.setText("Keine Zahl für die Wurzel angegeben!");
            return;
        }
        try {
            double value = Double.parseDouble(input);
            IOperation op = OperationFactory.getOperation(operation);
            double result = op.execute(value);
            displayManager.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            displayManager.setText("Invalid input for " + operation);
        } catch (IllegalArgumentException ex) {
            displayManager.setText(ex.getMessage());
        }
    }



    private void validateAndCalculateFactorial() {
        String input = displayManager.getInputField().getText().trim();
        if (input.matches("\\d+!")) {
            calculateSingleOperandOperation("!");
        } else {
            displayManager.setText("Ungültige Faktorial-Eingabe!");
        }
    }


    private void performOperation() {
        String input = displayManager.getInputField().getText().trim();
        if (!input.contains(" ")) {
            displayManager.setText("Ungültige Eingabe!");
            return;
        }

        String[] parts = input.split(" ");
        if (parts.length < 3) {
            displayManager.setText("Unvollständige Eingabe!");
            return;
        }

        try {
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            IOperation operation = OperationFactory.getOperation(operator);
            double result = operation.execute(num1, num2);

            displayManager.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            displayManager.setText("Fehler bei der Zahleneingabe!");
        } catch (IllegalArgumentException e) {
            displayManager.setText(e.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
