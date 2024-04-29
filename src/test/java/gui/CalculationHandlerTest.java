package gui;

import operation.IOperation;
import operation.OperationFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculationHandlerTest {
    @Mock
    private DisplayManager displayManager;
    @Mock
    private IOperation operation;

    private CalculationHandler calculationHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculationHandler = new CalculationHandler(displayManager);
    }

    @Test
    public void testHandleSingleOperandOperation_sqrt() {
        when(displayManager.getInputField()).thenReturn(new JTextField());
        String input = "√9";
        calculationHandler.handleSingleOperandOperation(input, "√");
        verify(displayManager).setText("3.00000");
    }

    @Test
    public void testHandleSingleOperandOperation_invalidInput() {
        String input = "√abc";
        calculationHandler.handleSingleOperandOperation(input, "√");
        verify(displayManager).setText("Fehler: Ungültige Zahleneingabe für √");
    }

    @Test
    public void testHandleSpecialFunction() {
        when(displayManager.getInputField()).thenReturn(new JTextField("25"));
        when(OperationFactory.getOperation("log")).thenReturn(operation);
        when(operation.execute(25)).thenReturn(Math.log(25));

        calculationHandler.handleSpecialFunction("log");
        verify(displayManager).setText(String.format("%.5f", Math.log(25)));
    }

    @Test
    public void testHandleFactorial_validInput() {
        String input = "5!";
        when(OperationFactory.getOperation("!")).thenReturn(operation);
        when(operation.execute(5)).thenReturn(120.0);  // Beispiel für 5!

        calculationHandler.handleFactorial(input);
        verify(displayManager).setText("120.00000");
    }

    @Test
    public void testHandleFactorial_invalidInput() {
        String input = "5x!";
        calculationHandler.handleFactorial(input);
        verify(displayManager).setText("Fehler: Faktorial-Operation erfordert eine Zahl gefolgt von einem Ausrufezeichen.");
    }
}
