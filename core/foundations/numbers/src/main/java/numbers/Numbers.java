package numbers;

public class Numbers {

    // ---- Direct recursion (_rec) ----

    public static int sumOfFirstNRec(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfFirstNRec(n - 1);
    }

    public static int factorialRec(int n) {
        if (n <= 0) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }

    public static int fibonacciRec(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static int greatestCommonDivisorRec(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisorRec(b, a % b);
    }

    public static int leastCommonMultipleRec(int a, int b) {
        return (a * b) / greatestCommonDivisorRec(a, b);
    }

    // ---- Accumulator recursion (_acc): educational bridge, no TCO in Java ----

    public static int sumOfFirstNAcc(int n) {
        return sumOfFirstNAccHelp(n, 0);
    }

    private static int sumOfFirstNAccHelp(int n, int acc) {
        if (n <= 0) {
            return acc;
        }
        return sumOfFirstNAccHelp(n - 1, n + acc);
    }

    public static int factorialAcc(int n) {
        return factorialAccHelp(n, 1);
    }

    private static int factorialAccHelp(int n, int acc) {
        if (n <= 1) {
            return acc;
        }
        return factorialAccHelp(n - 1, n * acc);
    }

    public static int fibonacciAcc(int n) {
        return fibonacciAccHelp(n, 0, 1);
    }

    private static int fibonacciAccHelp(int n, int acc2, int acc1) {
        if (n <= 0) {
            return acc2;
        }
        if (n <= 2) {
            return acc1 + acc2;
        }
        return fibonacciAccHelp(n - 1, acc1, acc1 + acc2);
    }

    public static int greatestCommonDivisorAcc(int a, int b) {
        return greatestCommonDivisorAccHelp(a, b);
    }

    private static int greatestCommonDivisorAccHelp(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisorAccHelp(b, a % b);
    }

    public static int leastCommonMultipleAcc(int a, int b) {
        return (a * b) / greatestCommonDivisorAcc(a, b);
    }

    // ---- Iterative (_ite) ----

    public static int sumOfFirstNIte(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int factorialIte(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int fibonacciIte(int n) {
        if (n <= 1) {
            return n;
        }
        int acc2 = 0;
        int acc1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = acc1 + acc2;
            acc2 = acc1;
            acc1 = temp;
        }
        return acc1;
    }

    public static int greatestCommonDivisorIte(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int leastCommonMultipleIte(int a, int b) {
        return (a * b) / greatestCommonDivisorIte(a, b);
    }
}
