package gui;

import controller.CalculationHandler;
import operation.OperationFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorGUITest {
    private CalculatorGUI calculatorGUI;
    private JTextField mockedField;

    @Mock
    private DisplayManager displayManager;
    @Mock
    private CalculationHandler calculationHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockedField = new JTextField();
        when(displayManager.getInputField()).thenReturn(mockedField);

        calculatorGUI = new CalculatorGUI();  // This would normally create its own instances, so you might need to inject mocks

        // Reflectively inject mocks if constructor injection isn't possible
        calculatorGUI.displayManager = this.displayManager;
        calculatorGUI.calculationHandler = this.calculationHandler;
    }

    @Test
    public void testPerformCalculation_handlesFactorial() {
        mockedField.setText("5!");
        when(OperationFactory.getOperation("!")).thenReturn((operands) -> {
            return factorial(operands[0]);
        });

        calculatorGUI.performCalculation();

        verify(calculationHandler).handleFactorial("5!");
        verify(displayManager).setText(anyString());  // Check if display is set
    }

    @Test
    public void testPerformCalculation_handlesSquareRoot() {
        mockedField.setText("√25");
        calculatorGUI.performCalculation();
        verify(calculationHandler).handleSingleOperandOperation("√25", "√");
    }

    @Test
    public void testPerformCalculation_handlesNormalCalculation() {
        mockedField.setText("10 / 2");
        when(OperationFactory.getOperation("/")).thenReturn((operands) -> operands[0] / operands[1]);

        calculatorGUI.performCalculation();

        verify(displayManager).setText("5.00000");
    }

    @Test
    public void testParseSecondOperand_withPercentage() {
        double result = calculatorGUI.parseSecondOperand("50%");
        assertEquals(0.5, result, 0.01);
    }

    @Test
    public void testParseSecondOperand_withoutPercentage() {
        double result = calculatorGUI.parseSecondOperand("50");
        assertEquals(50, result, 0.01);
    }

    private double factorial(double num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }
}