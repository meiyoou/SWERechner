package gui;

import javax.swing.*;
import java.awt.*;

public class DisplayManager {
    private JTextField inputField;

    public DisplayManager() {
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setEditable(false);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        inputField.setPreferredSize(new Dimension(0, 70));  // Höhe anpassen für bessere Sichtbarkeit
    }

    public JTextField getInputField() {
        return inputField;
    }

    public void setText(String text) {
        inputField.setText(text);
    }

    // Hinzufügen von Text zum aktuellen Inhalt des Eingabefelds
    public void appendText(String text) {
        inputField.setText(inputField.getText() + text);
    }

    // Löscht den Text im Eingabefeld
    public void clear() {
        inputField.setText("");
    }
}