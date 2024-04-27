package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionManager implements ActionListener {
    private CalculatorGUI calculator;

    public ActionManager(CalculatorGUI calculator) {
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.processAction(e);
    }
}
