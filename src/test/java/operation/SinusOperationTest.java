package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinusOperationTest {

    @Test
    public void testExecute_zeroDegrees() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(0);
        assertEquals(0.0, result, 0.00001, "Sinus of 0 degrees should be 0.");
    }

    @Test
    public void testExecute_ninetyDegrees() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(90);
        assertEquals(1.0, result, 0.00001, "Sinus of 90 degrees should be 1.");
    }

    @Test
    public void testExecute_oneEightyDegrees() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(180);
        assertEquals(0.0, result, 0.00001, "Sinus of 180 degrees should be 0.");
    }

    @Test
    public void testExecute_twoSeventyDegrees() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(270);
        assertEquals(-1.0, result, 0.00001, "Sinus of 270 degrees should be -1.");
    }

    @Test
    public void testExecute_threeSixtyDegrees() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(360);
        assertEquals(0.0, result, 0.00001, "Sinus of 360 degrees should return to 0.");
    }

    @Test
    public void testExecute_negativeAngle() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(-90);
        assertEquals(-1.0, result, 0.00001, "Sinus of -90 degrees should be -1.");
    }

    @Test
    public void testExecute_arbitraryAngle() {
        SinusOperation operation = new SinusOperation();
        double result = operation.execute(45);
        assertEquals(Math.sin(Math.toRadians(45)), result, 0.00001, "Sinus of 45 degrees should match the computed value.");
    }
}
