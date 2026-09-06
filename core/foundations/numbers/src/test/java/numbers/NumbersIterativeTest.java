package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumbersIterativeTest {

    @Test
    void testSumOfFirstNIte() {
        assertEquals(0, Numbers.sumOfFirstNIte(0));
        assertEquals(6, Numbers.sumOfFirstNIte(3));
    }

    @Test
    void testFactorialIte() {
        assertEquals(1, Numbers.factorialIte(0));
        assertEquals(24, Numbers.factorialIte(4));
    }

    @Test
    void testFibonacciIte() {
        assertEquals(0, Numbers.fibonacciIte(0));
        assertEquals(1, Numbers.fibonacciIte(1));
        assertEquals(8, Numbers.fibonacciIte(6));
    }

    @Test
    void testGreatestCommonDivisorIte() {
        assertEquals(4, Numbers.greatestCommonDivisorIte(12, 8));
        assertEquals(1, Numbers.greatestCommonDivisorIte(7, 5));
    }

    @Test
    void testLeastCommonMultipleIte() {
        assertEquals(12, Numbers.leastCommonMultipleIte(4, 6));
        assertEquals(24, Numbers.leastCommonMultipleIte(6, 8));
    }
}
