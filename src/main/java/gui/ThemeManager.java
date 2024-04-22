package gui;
import javax.swing.*;
import java.awt.*;

public class ThemeManager {
    public static final Color DEFAULT_DIGIT_COLOR = new Color(173, 216, 230);
    public static final Color DEFAULT_CLEAR_BUTTON_COLOR = new Color(255, 102, 102);
    public static final Color DEFAULT_EQUALS_BUTTON_COLOR = new Color(255, 255, 102);
    public static final Color DEFAULT_OPERATION_BUTTON_COLOR = new Color(255, 165, 101);
    public static final Color DEFAULT_SPECIAL_BUTTON_COLOR = new Color(149, 238, 105, 255);


    public static final Color DEFAULT_BUTTON_COLOR = Color.WHITE;
    public static final Color DEFAULT_OPERATOR_COLOR = Color.BLUE;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.LIGHT_GRAY;
    private static final Color DEFAULT_FOREGROUND_COLOR = Color.WHITE;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 18);

    public static void applyDefaultTheme(JFrame frame) {
        frame.getContentPane().setBackground(DEFAULT_BACKGROUND_COLOR);
        setUIFont(new javax.swing.plaf.FontUIResource(DEFAULT_FONT));
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f){
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }

    }

    public static void setButtonTheme(JButton button, Color color){
        button.setBackground(color);
        button.setFont(DEFAULT_FONT);
    }
}
