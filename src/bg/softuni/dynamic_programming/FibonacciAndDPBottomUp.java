package bg.softuni.dynamic_programming;

import java.util.Scanner;

public class FibonacciAndDPBottomUp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int fibonacciNumber = scanner.nextInt();

        long result = fibonacci(fibonacciNumber);
        System.out.println(result);

        scanner.close();
    }

    private static long fibonacci(int n) {

        long[] memo = new long[n + 2];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

        return memo[n];
    }
}
