import dvanol.Calculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class testCalculator {

    @Test
    public void testSum() {
        assertEquals(Calculator.sum(1, 2), 3, 0);
        assertEquals(Calculator.subtract(Double.MAX_VALUE, 2), 0, 0);
    }

    @Test
    public void testSubstruct() {
        assertEquals(Calculator.subtract(10, 2), 8, 0);
        assertEquals(Calculator.subtract(Double.MAX_VALUE, -2), 0, 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(10, 2), 20, 0);
        assertEquals(Calculator.multiply(Double.MAX_VALUE, 2), 0, 0);
    }

    @Test
    public void testDivide() {
        assertEquals(Calculator.divide(10, 2), 5, 0);
        assertEquals(Calculator.divide(Double.MAX_VALUE, 0.2), 0, 0);
        assertEquals(Calculator.divide(10, 0), 0, 0);
    }
}