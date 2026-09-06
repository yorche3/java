package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumbersRecursiveTest {

    @Test
    void testSumOfFirstNRec() {
        assertEquals(0, Numbers.sumOfFirstNRec(0));
        assertEquals(6, Numbers.sumOfFirstNRec(3));
    }

    @Test
    void testFactorialRec() {
        assertEquals(1, Numbers.factorialRec(0));
        assertEquals(24, Numbers.factorialRec(4));
    }

    @Test
    void testFibonacciRec() {
        assertEquals(0, Numbers.fibonacciRec(0));
        assertEquals(1, Numbers.fibonacciRec(1));
        assertEquals(8, Numbers.fibonacciRec(6));
    }

    @Test
    void testGreatestCommonDivisorRec() {
        assertEquals(4, Numbers.greatestCommonDivisorRec(12, 8));
        assertEquals(1, Numbers.greatestCommonDivisorRec(7, 5));
    }

    @Test
    void testLeastCommonMultipleRec() {
        assertEquals(12, Numbers.leastCommonMultipleRec(4, 6));
        assertEquals(24, Numbers.leastCommonMultipleRec(6, 8));
    }
}
