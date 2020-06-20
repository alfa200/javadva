import dvanol.Calculator;
import dvanol.InfiniteException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class testCalculator {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSum() {
        assertEquals(Calculator.sum(1, 2), 3, 0);
        thrown.expect(InfiniteException.class);
        thrown.expectMessage("Результат не входит сторого в пределы double");
        Calculator.sum(Double.MAX_VALUE, 2);
    }

    @Test
    public void testSubstruct() {
        assertEquals(Calculator.subtract(10, 2), 8, 0);
        thrown.expect(InfiniteException.class);
        thrown.expectMessage("Результат не входит сторого в пределы double");
        Calculator.subtract(Double.MAX_VALUE, -2);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(10, 2), 20, 0);
        thrown.expect(InfiniteException.class);
        thrown.expectMessage("Результат не входит сторого в пределы double");
        Calculator.multiply(Double.MAX_VALUE, 2);
    }

    @Test()
    public void testDivide() {
        assertEquals(Calculator.divide(10, 2), 5, 0);
        thrown.expect(InfiniteException.class);
        thrown.expectMessage("Результат не входит сторого в пределы double");
        Calculator.divide(Double.MAX_VALUE, 0.2);
        Calculator.divide(10, 0);
    }
}