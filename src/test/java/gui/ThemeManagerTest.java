package gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ThemeManagerTest {
    private JButton mockButton;

    @BeforeEach
    public void setUp() {
        // Erstellen eines gemockten JButton
        mockButton = mock(JButton.class);
    }

    @Test
    public void testSetButtonThemeDigit() {
        ThemeManager.setButtonTheme(mockButton, "digit");
        verify(mockButton).setBackground(new Color(240, 240, 240));
        verify(mockButton).setForeground(Color.BLACK);
        verify(mockButton).setFont(new Font("SansSerif", Font.BOLD, 20));
    }

    @Test
    public void testSetButtonThemeOperation() {
        ThemeManager.setButtonTheme(mockButton, "operation");
        verify(mockButton).setBackground(new Color(200, 200, 255));
        verify(mockButton).setForeground(Color.BLACK);
        verify(mockButton).setFont(new Font("SansSerif", Font.BOLD, 20));
    }

    @Test
    public void testSetButtonThemeDefault() {
        ThemeManager.setButtonTheme(mockButton, "unknown");
        verify(mockButton).setBackground(Color.LIGHT_GRAY);
        verify(mockButton).setForeground(Color.BLACK);
        verify(mockButton).setFont(new Font("SansSerif", Font.BOLD, 20));
    }
}
