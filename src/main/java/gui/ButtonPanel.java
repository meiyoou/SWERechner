package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton[] digitButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton decimalButton; // Button für den Dezimalpunkt
    private ActionListener actionListener;

    public ButtonPanel(ActionListener listener) {
        this.actionListener = listener;
        setLayout(new GridLayout(7, 6, 10, 10));  // Anpassung der Grid-Dimensionen, um Platz für den zusätzlichen Button zu schaffen
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  // Fügt einen Rand von 5 Pixeln um das Panel hinzu
        initializeButtons();
    }

    private void initializeButtons() {
        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = createButton(String.valueOf(i), "digit");
        }

        decimalButton = createButton(".", "digit");

        String[] ops = {"+", "-", "*", "/", "^", "√", "∛", "%", "sin", "cos", "tan", "log", "ln", "log10", "!", "mod", "round", "avg", "|x|"};
        operationButtons = new JButton[ops.length];
        for (int i = 0; i < ops.length; i++) {
            operationButtons[i] = createButton(ops[i], "operation");
        }

        equalsButton = createButton("=", "equals");
        clearButton = createButton("C", "clear");
    }

    private JButton createButton(String text, String theme) {
        JButton button = new JButton(text);
        ThemeManager.setButtonTheme(button, theme);
        button.addActionListener(actionListener);
        add(button);
        return button;
    }
}