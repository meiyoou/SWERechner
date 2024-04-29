package gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ButtonPanelTest {
    private ButtonPanel panel;
    private ActionListener mockListener;

    @BeforeEach
    void setUp() {
        mockListener = mock(ActionListener.class);
        panel = new ButtonPanel(mockListener);
    }

    @Test
    void testDigitButtonsCountAndProperties() {
        Component[] components = panel.getComponents();
        long digitButtonsCount = countComponentsByTypeAndText(components, JButton.class, "[0-9]");
        assertEquals(10, digitButtonsCount, "There should be 10 digit buttons");

        for (Component comp : components) {
            if (comp instanceof JButton && ((JButton) comp).getText().matches("[0-9]")) {
                JButton button = (JButton) comp;
                assertNotNull(button.getActionListeners()[0], "ActionListener should be assigned");
                // Check theme
                verifyTheme(button, "digit");
            }
        }
    }

    @Test
    void testOperationButtonsCountAndProperties() {
        Component[] components = panel.getComponents();
        String[] ops = {"+", "-", "*", "/", "^", "√", "%", "sin", "cos", "tan", "log", "!", "∛"};
        for (String op : ops) {
            long count = countComponentsByTypeAndText(components, JButton.class, op);
            assertEquals(1, count, "Each operation button should be present");
        }

        for (Component comp : components) {
            if (comp instanceof JButton && ((JButton) comp).getText().matches("\\+|-|\\*|/|\\^|√|%|sin|cos|tan|log|!|∛")) {
                JButton button = (JButton) comp;
                assertNotNull(button.getActionListeners()[0], "ActionListener should be assigned");
                // Check theme
                verifyTheme(button, "operation");
            }
        }
    }

    @Test
    void testEqualsButtonProperties() {
        JButton equalsButton = findButtonByText(panel, "=");
        assertNotNull(equalsButton, "Equals button should exist");
        assertNotNull(equalsButton.getActionListeners()[0], "ActionListener should be assigned");
        verifyTheme(equalsButton, "equals");
    }

    @Test
    void testClearButtonProperties() {
        JButton clearButton = findButtonByText(panel, "C");
        assertNotNull(clearButton, "Clear button should exist");
        assertNotNull(clearButton.getActionListeners()[0], "ActionListener should be assigned");
        verifyTheme(clearButton, "clear");
    }

    private JButton findButtonByText(JPanel panel, String text) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton && ((JButton) comp).getText().equals(text)) {
                return (JButton) comp;
            }
        }
        return null;
    }

    private long countComponentsByTypeAndText(Component[] components, Class<JButton> btnClass, String text) {
        return Arrays.stream(components)
                .filter(btnClass::isInstance)
                .map(btnClass::cast)
                .filter(button -> button.getText().matches(text))
                .count();
    }

    private void verifyTheme(JButton button, String expectedType) {
        Color expectedBg = expectedType.equals("digit") ? new Color(240, 240, 240) : new Color(200, 200, 255);
        assertEquals(expectedBg, button.getBackground(), "Background should match the theme");
        assertEquals(Color.BLACK, button.getForeground(), "Foreground should be black");
        assertEquals(new Font("SansSerif", Font.BOLD, 20), button.getFont(), "Font should match the theme");
    }
}
