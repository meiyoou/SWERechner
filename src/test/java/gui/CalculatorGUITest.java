package gui;

import gui.CalculatorGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorGUITest {

    private CalculatorGUI calculatorGUI;

    @BeforeEach
    public void setUp() {
        calculatorGUI = new CalculatorGUI();
    }

    @Test
    public void testCalculatorGUINotNull() {
        assertNotNull(calculatorGUI);
    }

    @Test
    public void testCalculatorGUITitle() {
        assertEquals("Calculator App", calculatorGUI.getTitle());
    }

    @Test
    public void testCalculatorGUISize() {
        assertEquals(new Dimension(600, 800), calculatorGUI.getSize());
    }

    @Test
    public void testCalculatorGUIActionListener() {
        for (JButton button: calculatorGUI.getDigitButtons()) {
            assertNotNull(button.getActionListeners());
        }
        
        for (JButton button: calculatorGUI.getOperationButtons()) {
            assertNotNull(button.getActionListeners());
        }
    }
    
    @Test
    public void testCalculatorGUIInputField() {
        assertEquals(JTextField.class, calculatorGUI.getInputField().getClass());
        assertEquals(0, calculatorGUI.getInputField().getText().length());
    }

    @Test
    public void testCalculatorGUIDigitButtons() {
        assertEquals(10, calculatorGUI.getDigitButtons().length);
        for (int i = 0; i < 10; i++) {
            assertEquals(String.valueOf(i), calculatorGUI.getDigitButtons()[i].getText());
        }
    }

    @Test
    public void testCalculatorGUIOperationButtons() {
        assertEquals(13, calculatorGUI.getOperationButtons().length);
        String[] expectedOperationButtonTexts = 
            new String[]{"+", "-", "*", "/", "^", "√", "%", "sin", "cos", "tan", "log", "!", "∛"};
        for (int i = 0; i < expectedOperationButtonTexts.length; i++) {
            assertEquals(expectedOperationButtonTexts[i], calculatorGUI.getOperationButtons()[i].getText());
        }
    }

    @Test
    public void testCalculatorGUIEqualsButton() {
        assertEquals("=", calculatorGUI.getEqualsButton().getText());
        assertNotNull(calculatorGUI.getEqualsButton().getActionListeners());
    }

    @Test
    public void testCalculatorGUIClearButton() {
        assertEquals("C", calculatorGUI.getClearButton().getText());
        assertNotNull(calculatorGUI.getClearButton().getActionListeners());
    }

   // here add rest of the tests for the required topic...
   @Test
   public void testActionButtonPerformedWithDigit() {
       JButton button = new JButton("1");
       button.addActionListener(calculatorGUI);
       button.doClick();
       assertEquals("1", calculatorGUI.getInputField().getText());
   }

   @Test
   public void testActionButtonPerformedWithClearCommand() {
       JButton button = new JButton("C");
       button.addActionListener(calculatorGUI);
       calculatorGUI.getInputField().setText("123");
       button.doClick();
       assertEquals("", calculatorGUI.getInputField().getText());
   }

  @Test
  public void testActionButtonPerformedWithEqualsCommand() {
      JButton oneButton = new JButton("1");
      oneButton.addActionListener(calculatorGUI);
      oneButton.doClick();

      JButton plusButton = new JButton("+");
      plusButton.addActionListener(calculatorGUI);
      plusButton.doClick();

     oneButton.doClick();

     JButton equalsButton = new JButton("=");
     equalsButton.addActionListener(calculatorGUI);
     equalsButton.doClick();

     assertEquals("2.0", calculatorGUI.getInputField().getText());
 }
}
