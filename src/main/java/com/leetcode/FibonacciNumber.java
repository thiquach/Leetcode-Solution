package main.java.com.leetcode;

// Fibonacci sequence 0, 1, 1, 2, 3. 5 and so on
// fib(n) = fib(n-1) + fib(n-2)
// fib_memo(n, memo) store calculated fib in memo array to save time
// fib_bottom_up(n, bottom_up) bottom up approach, pre-calculate fib in bottom_up array
public class FibonacciNumber {
    public static void main(String[] args) {
        int n =35;
        int[] memo = new int[n+1];
        int[] bottom_up = fillBottomUp(n);
        System.out.println("fib " + n + " is " + fib(n));
        System.out.println("fib_memo " + n + " is " + fib_memo(n, memo));
        System.out.println("fib_bottom_up " + n + " is " + fib_bottom_up(n, bottom_up));
    }

    private static int[] fillBottomUp(int n) {
        int[] result = new int[n+1];

        result[0] = 0;
        result[1] = 1;
        for (int i=2; i<n+1; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }

    private static int fib(int n) {
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fib(n - 2) + fib(n - 1);
        }
        return result;
    }

    private static int fib_memo(int n, int[] memo) {
        int result;
        if (memo[n] != 0) {
            return memo[n];
        } else if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fib_memo(n - 1, memo) + fib_memo(n - 2, memo);
        }
        memo[n] = result;
        return result;
    }

    private static int fib_bottom_up(int n, int[] bottom_up) {
        int result;
        if (bottom_up[n] != 0) {
            return bottom_up[n];
        } else if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fib_memo(n - 1, bottom_up) + fib_memo(n - 2, bottom_up);
        }
        bottom_up[n] = result;
        return result;
    }

}
