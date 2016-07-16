package bg.softuni.dynamic_programming;

import java.util.Scanner;

public class FibonacciAndDPTopDown {

    static long[] memo;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int fibNum = scanner.nextInt();

        memo = new long[fibNum + 1];
        long result = fibonacci(fibNum);

        System.out.println(result);
        scanner.close();

    }

    private static long fibonacci(int n) {

        if (memo[n] != 0)
            return memo[n];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return memo[n];
    }
}
