package main.java.com.leetcode;

// Fibonacci sequence 0, 1, 1, 2, 3. 5 and so on
// fib(n) = fib(n-1) + fib(n-2)
public class FibonacciNumber {
    public static void main(String[] args) {
        int n =2;
        System.out.println("fib " + n + " is " + fibonacciNumber(n));
    }

    private static int fibonacciNumber(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacciNumber(n - 1) + fibonacciNumber(n -2);
    }
}
