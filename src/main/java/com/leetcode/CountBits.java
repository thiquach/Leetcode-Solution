package main.java.com.leetcode;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int n = 7;

        int[] result = countBits(n);
        System.out.println("n is " + n + " count " + Arrays.toString(result));
    }

    public static int[] countBits(int n) {
        if (n < 0) {
            return new int[0];
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = result[i>>1] + (i & 1);
        }
        return result;
    }
}
