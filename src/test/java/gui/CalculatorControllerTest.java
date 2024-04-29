package gui;

import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;

import controller.CalculationHandler;
import controller.CalculatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    private CalculatorController controller;
    private CalculatorGUI mockCalculator;
    private DisplayManager mockDisplayManager;
    private CalculationHandler mockCalculationHandler;
    private ActionEvent mockActionEvent;

    @BeforeEach
    public void setUp() {
        mockCalculator = mock(CalculatorGUI.class);
        mockDisplayManager = mock(DisplayManager.class);
        mockCalculationHandler = mock(CalculationHandler.class);

        when(mockCalculator.getDisplayManager()).thenReturn(mockDisplayManager);

        controller = new CalculatorController(mockCalculator);
    }

    @Test
    public void testNumberInput() {
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "5");
        controller.actionPerformed(mockActionEvent);
        verify(mockDisplayManager).appendText("5");
    }

    @Test
    public void testDecimalInput() {
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ".");
        controller.actionPerformed(mockActionEvent);
        verify(mockDisplayManager).appendText(".");
    }

    @Test
    public void testClearCommand() {
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "C");
        controller.actionPerformed(mockActionEvent);
        verify(mockDisplayManager).clear();
    }

    @Test
    public void testEqualsCommand() {
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=");
        controller.actionPerformed(mockActionEvent);
        verify(mockCalculator).performCalculation();
    }

    @Test
    public void testOperatorsInput() {
        String[] operators = {"+", "-", "*", "/", "^"};
        for (String operator : operators) {
            mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, operator);
            controller.actionPerformed(mockActionEvent);
            verify(mockDisplayManager).appendText(" " + operator + " ");
        }
    }

    @Test
    public void testFactorialCommandValidInput() {
        when(mockDisplayManager.getInputField().getText()).thenReturn("5!");
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "!");
        controller.actionPerformed(mockActionEvent);
        verify(mockCalculationHandler).handleFactorial("5!");
    }

    @Test
    public void testFactorialCommandInvalidInput() {
        when(mockDisplayManager.getInputField().getText()).thenReturn("5");
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "!");
        controller.actionPerformed(mockActionEvent);
        verify(mockDisplayManager).appendText("!");
    }

    @Test
    public void testSqrtCommand() {
        when(mockDisplayManager.getInputField().getText()).thenReturn("16");
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "√");
        controller.actionPerformed(mockActionEvent);
        verify(mockCalculationHandler).handleSingleOperandOperation("16", "√");
    }

    @Test
    public void testSpecialFunction() {
        mockActionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "someFunction");
        controller.actionPerformed(mockActionEvent);
        verify(mockCalculationHandler).handleSpecialFunction("someFunction");
    }
}
