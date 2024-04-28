package operation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TangensOperationTest {

    private static final double DELTA = 0.0001; // Toleranz für Gleitkommavergleiche

    @Test
    public void testTanOfZeroDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(0);
        assertEquals(0.0, result, DELTA, "tan(0 degrees) should be 0");
    }

    @Test
    public void testTanOfFortyFiveDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(45);
        assertEquals(1.0, result, DELTA, "tan(45 degrees) should be 1");
    }

    @Test
    public void testTanOfNinetyDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(90);
        // Testen auf eine große Zahl, da tan(90) theoretisch gegen unendlich geht
        assertTrue(Double.isInfinite(result), "tan(90 degrees) should be infinity");
    }

    @Test
    public void testTanOfNegativeDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(-45);
        assertEquals(-1.0, result, DELTA, "tan(-45 degrees) should be -1");
    }

    @Test
    public void testTanOfOneEightyDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(180);
        assertEquals(0.0, result, DELTA, "tan(180 degrees) should be 0");
    }

    @Test
    public void testTanOfTwoSeventyDegrees() {
        TangensOperation tanOp = new TangensOperation();
        double result = tanOp.execute(270);
        // Testen auf eine große Zahl, da tan(270) theoretisch gegen unendlich geht
        assertTrue(Double.isInfinite(result), "tan(270 degrees) should be infinity");
    }
}
