package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diese Klasse übernimmt die Rolle des Controllers im MVC-Pattern.
 * Sie ist verantwortlich für das Handling der Events, die von der GUI-Komponente generiert werden.
 */
public class CalculatorController implements ActionListener {
    private CalculatorGUI calculator;
    private DisplayManager displayManager;

    public CalculatorController(CalculatorGUI calculator) {
        this.calculator = calculator;
        this.displayManager = calculator.getDisplayManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Ziffern und Punkt verarbeiten
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
                    displayManager.appendText(command);
                    break;
                default:
                    calculator.handleSpecialFunction(command);
                    break;
            }
        }
    }
}
