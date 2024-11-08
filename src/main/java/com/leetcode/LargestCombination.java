package main.java.com.leetcode;

import java.util.Arrays;

// 2275
public class LargestCombination {
    public static void main(String[] args) {
        int[] candidates = {16,17,71,62,12,24,14};
//        int[] candidates = {8,8};
        System.out.println("largest combination " + largestCombination(candidates));
    }

    public static int largestCombination(int[] candidates) {
        if (candidates.length < 1)
            return 0;

        int len = candidates.length;
        int[] bitPositionCount = new int[24];
        int maxCount = 0;
        for (int i=0; i<len; i++) {
            bitPosition(candidates[i], bitPositionCount);
        }
        for (int i=0; i<24; i++) {
            maxCount = Math.max(maxCount, bitPositionCount[i]);
        }
        return maxCount;
    }

    private static void bitPosition(int n, int[] bitPostionCount) {
        if (n < 1)
            return;

        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                bitPostionCount[count]++;
            }
            n = n >> 1;
            count++;
        }
    }
}
