package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(5, Calculator.addition(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(3, Calculator.subtraction(5, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(12, Calculator.multiplication(3, 4));
    }

    @Test
    void testDivision() {
        assertEquals(3, Calculator.division(10, 3));
    }

    @Test
    void testModulus() {
        assertEquals(1, Calculator.modulus(10, 3));
    }
}
