package gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

public class DisplayManagerTest {
    private DisplayManager displayManager;
    private JTextField mockInputField;

    @BeforeEach
    public void setUp() throws Exception {
        displayManager = new DisplayManager();
        mockInputField = mock(JTextField.class);

        // Zugriff auf das private Feld 'inputField' mittels Reflection
        Field field = DisplayManager.class.getDeclaredField("inputField");
        field.setAccessible(true);
        field.set(displayManager, mockInputField);
    }


    @Test
    public void testSetText() {
        String testText = "Test";
        displayManager.setText(testText);
        verify(mockInputField).setText(testText);
    }

    @Test
    public void testAppendText() {
        // Einstellen des aktuellen Textes im InputField
        when(mockInputField.getText()).thenReturn("Hello");
        String appendText = " World";

        displayManager.appendText(appendText);

        verify(mockInputField).getText(); // Verifizieren, dass getText aufgerufen wurde
        verify(mockInputField).setText("Hello World"); // Verifizieren, dass setText mit dem erwarteten Wert aufgerufen wurde
    }

    @Test
    public void testClear() {
        displayManager.clear();
        verify(mockInputField).setText(""); // Verifizieren, dass setText mit einem leeren String aufgerufen wurde
    }
}
