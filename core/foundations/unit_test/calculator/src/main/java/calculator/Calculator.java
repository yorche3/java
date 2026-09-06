package calculator;

public class Calculator {

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    // Repeated addition, no * operator
    public static int multiplication(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = addition(result, a);
        }
        return result;
    }

    // Repeated subtraction, no / operator
    public static int division(int a, int b) {
        int count = 0;
        while (a >= b) {
            a = subtraction(a, b);
            count++;
        }
        return count;
    }

    // No % operator, built from division and multiplication
    public static int modulus(int a, int b) {
        int q = division(a, b);
        int p = multiplication(q, b);
        return subtraction(a, p);
    }
}
