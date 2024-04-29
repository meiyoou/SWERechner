package gui;

import controller.ActionManager;
import controller.CalculatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActionManagerTest {
    private ActionManager actionManager;
    private CalculatorController mockController;

    @BeforeEach
    public void setUp() {
        // Erstellen eines Mocks für CalculatorController
        mockController = mock(CalculatorController.class);
        // Erstellen der ActionManager Instanz mit dem gemockten Controller
        actionManager = new ActionManager(mockController);
    }

    @Test
    public void testActionPerformed() {
        // Erstellen eines ActionEvents Mocks
        ActionEvent mockEvent = mock(ActionEvent.class);

        // Aufrufen der actionPerformed Methode von ActionManager
        actionManager.actionPerformed(mockEvent);

        // Überprüfen, ob actionPerformed von CalculatorController aufgerufen wurde
        verify(mockController).actionPerformed(mockEvent);
    }
}
