package main.java.com.leetcode;

import java.util.Arrays;

public class FactorialOfANumber {
    public static void main(String[] args) {
        int num = 5;

        System.out.println("num " + num + " factorial " + factorial(num));
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }
}
