package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosinusOperationTest {

    @Test
    public void testExecute_cosOfZeroDegrees() {
        CosinusOperation operation = new CosinusOperation();
        double result = operation.execute(0);
        assertEquals(1.0, result, 0.00001, "The cosine of 0 degrees should be 1.");
    }

    @Test
    public void testExecute_cosOfNinetyDegrees() {
        CosinusOperation operation = new CosinusOperation();
        double result = operation.execute(90);
        assertEquals(0.0, result, 0.00001, "The cosine of 90 degrees should be 0.");
    }

    @Test
    public void testExecute_cosOfOneEightyDegrees() {
        CosinusOperation operation = new CosinusOperation();
        double result = operation.execute(180);
        assertEquals(-1.0, result, 0.00001, "The cosine of 180 degrees should be -1.");
    }

    @Test
    public void testExecute_cosOfThreeSixtyDegrees() {
        CosinusOperation operation = new CosinusOperation();
        double result = operation.execute(360);
        assertEquals(1.0, result, 0.00001, "The cosine of 360 degrees should be 1.");
    }

    @Test
    public void testExecute_cosOfNegativeDegrees() {
        CosinusOperation operation = new CosinusOperation();
        double result = operation.execute(-90);
        assertEquals(0.0, result, 0.00001, "The cosine of -90 degrees should be 0.");
    }
}
