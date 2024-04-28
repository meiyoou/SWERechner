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

    // Setzt den Text im Eingabefeld, entfernt unnötige Dezimalstellen
    public void setText(String text) {
        if (text == null) {
            inputField.setText("");
        } else {
            try {
                // Versucht das Textergebnis als Double zu interpretieren
                double value = Double.parseDouble(text);
                if (value == (long) value) {
                    // Keine Dezimalstellen nötig, formatiere als Long
                    inputField.setText(String.format("%d", (long) value));
                } else {
                    // Dezimalstellen nötig, formatiere als Double
                    inputField.setText(String.format("%s", value));
                }
            } catch (NumberFormatException e) {
                // Falls keine valide Zahl, setze den ursprünglichen Text
                inputField.setText(text);
            }
        }
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
