package operation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractionOperationTest {

    @Test
    public void testSubtractTwoPositiveNumbers() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(10, 5);
        assertEquals(5.0, result, "10 - 5 should equal 5");
    }

    @Test
    public void testSubtractTwoNegativeNumbers() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(-10, -5);
        assertEquals(-5.0, result, "-10 - (-5) should equal -5");
    }

    @Test
    public void testSubtractPositiveAndNegativeNumber() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(10, -5);
        assertEquals(15.0, result, "10 - (-5) should equal 15");
    }

    @Test
    public void testSubtractNegativeAndPositiveNumber() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(-10, 5);
        assertEquals(-15.0, result, "-10 - 5 should equal -15");
    }

    @Test
    public void testSubtractZero() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(0, 0);
        assertEquals(0.0, result, "0 - 0 should equal 0");
    }

    @Test
    public void testSubtractFromZero() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(0, 5);
        assertEquals(-5.0, result, "0 - 5 should equal -5");
    }

    @Test
    public void testSubtractToZero() {
        SubtractionOperation subtraction = new SubtractionOperation();
        double result = subtraction.execute(5, 5);
        assertEquals(0.0, result, "5 - 5 should equal 0");
    }
}
