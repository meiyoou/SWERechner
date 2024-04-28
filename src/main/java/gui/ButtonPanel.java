package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton[] digitButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private ActionListener actionListener;

    public ButtonPanel(ActionListener listener) {
        this.actionListener = listener;
        setLayout(new GridLayout(6, 6, 10, 10));  // 6 Zeilen, 6 Spalten, 10 Pixel horizontaler und vertikaler Abstand
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  // Fügt einen Rand von 5 Pixeln um das Panel hinzu
        initializeButtons();
    }

    private void initializeButtons() {
        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            ThemeManager.setButtonTheme(digitButtons[i], "digit");
            digitButtons[i].addActionListener(actionListener);
            add(digitButtons[i]);
        }

        String[] ops = {"+", "-", "*", "/", "^", "√", "∛", "%", "sin", "cos", "tan", "log", "ln", "log10", "!", "mod", "round", "avg", "|x|"};
        operationButtons = new JButton[ops.length];
        for (int i = 0; i < ops.length; i++) {
            operationButtons[i] = new JButton(ops[i]);
            ThemeManager.setButtonTheme(operationButtons[i], "operation");
            operationButtons[i].addActionListener(actionListener);
            add(operationButtons[i]);
        }

        equalsButton = new JButton("=");
        ThemeManager.setButtonTheme(equalsButton, "equals");
        equalsButton.addActionListener(actionListener);
        add(equalsButton);

        clearButton = new JButton("C");
        ThemeManager.setButtonTheme(clearButton, "clear");
        clearButton.addActionListener(actionListener);
        add(clearButton);
    }
}
