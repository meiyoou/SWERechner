package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionManager implements ActionListener {
    private CalculatorController controller;

    public ActionManager(CalculatorController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
    }
}
