package main.java.com.leetcode;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int n = 5;

        int[] result = countingBits(n);
        System.out.println("n is " + n + " count " + Arrays.toString(result));
    }

    private static int[] countingBits(int n) {
        if (n < 0)
            return new int[0];

        int len = n+1;
        int[] result = new int[len];

        result[0] = 0;
        int bitsCount = 0;
        for (int i=1; i<len; i++) {
            String binString = Integer.toBinaryString(i);
            int index = binString.indexOf("1");
            while (index >= 0) {
                bitsCount++;
                index = binString.indexOf("1", index+1);
            }
            result[i] = bitsCount;
            bitsCount = 0;
        }
        return result;
    }
}
