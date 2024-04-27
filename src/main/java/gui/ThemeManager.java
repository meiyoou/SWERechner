package gui;

import javax.swing.*;
import java.awt.*;

public class ThemeManager {
    public static void setButtonTheme(JButton button, String type) {
        switch (type) {
            case "digit":
                button.setBackground(new Color(240, 240, 240)); // Hellgrau für Zifferntasten
                button.setForeground(Color.BLACK);
                break;
            case "operation":
                button.setBackground(new Color(200, 200, 255)); // Helles Blau für Operations-Tasten
                button.setForeground(Color.BLACK);
                break;
            default:
                button.setBackground(Color.LIGHT_GRAY);
                button.setForeground(Color.BLACK);
        }
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
    }
}
