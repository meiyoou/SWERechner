package gui;

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
            displayManager.appendText(command);
        } else {
            switch (command) {
                case "C":
                    displayManager.clear();
                    break;
                case "=":
                    calculator.performCalculation();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    displayManager.appendText(" " + command + " ");
                    break;
                case "%":
                case "!":
                case "√":
                    if (command.equals("√") && !displayManager.getInputField().getText().contains(" ")) {
                        calculationHandler.handleSingleOperandOperation(displayManager.getInputField().getText(), command);
                    } else {
                        displayManager.appendText(command);
                    }
                    break;
                default:
                    calculationHandler.handleSpecialFunction(command);
                    break;
            }
        }
    }
}
