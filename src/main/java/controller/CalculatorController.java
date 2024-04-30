package controller;

import gui.CalculatorGUI;
import gui.DisplayManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorGUI calculator;
    private DisplayManager displayManager;
    private CalculationHandler calculationHandler;

    public CalculatorController(CalculatorGUI calculator) {
        this.calculator = calculator;
        this.displayManager = calculator.getDisplayManager();
        this.calculationHandler = new CalculationHandler(displayManager);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            handleNumberInput(command);
        } else {
            handleOperationInput(command);
        }
    }

    private void handleNumberInput(String command) {
        displayManager.appendText(command);
    }

    private void handleOperationInput(String command) {
        switch (command) {
            case "C":
                displayManager.clear();
                break;
            case "=":
                calculator.performCalculation();
                break;
            default:
                handleMathOperation(command);
                break;
        }
    }

    private void handleMathOperation(String command) {
        if (command.matches("[+\\-*/^]")) {
            displayManager.appendText(" " + command + " ");
        } else if (command.equals("!")) {
            handleFactorial();
        } else if (command.equals("√")) {
            handleSqrt();
        } else {
            calculationHandler.handleSpecialFunction(command);
        }
    }
    private void handleFactorial() {
        String input = displayManager.getInputField().getText().trim();
        if (input.matches("\\d+\\!$")) {
            calculationHandler.handleFactorial(input);
        } else {
            displayManager.appendText("!");
        }
    }

    private void handleSqrt() {
        String input = displayManager.getInputField().getText().trim();
        if (!input.contains(" ")) {
            calculationHandler.handleSingleOperandOperation(input, "√");
        } else {
            displayManager.appendText("√");
        }
    }

}