package main.java.com.leetcode;

import java.util.Arrays;

// 2300 binary search, array, two pointers, sorting
public class SuccessfulPairs {
    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;

        int[] result = successfulPairs(spells, potions, success);
        System.out.println(" SuccessfulPairs result " + Arrays.toString(result));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len1 = spells.length;
        int len2 = potions.length;

        Arrays.sort(potions);
        int[] result = new int[len1];

        for (int i=0; i<len1; i++) {
            int low = 0;
            int high = len2 - 1;
            int count = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                long p = (long) spells[i] * potions[mid];

                if (p >= success) {
                    count = len2 - mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
