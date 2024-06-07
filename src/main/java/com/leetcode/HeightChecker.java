package main.java.com.leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println("Heights " + Arrays.toString(heights));

        int length = heights.length;
        int[] heightsCopy = heights.clone();
        boolean swapped;
        do {
            swapped = false;
            for (int i=0; i<length-1; i++) {
                if (heights[i] > heights[i+1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
            length--;
        } while (swapped);

        int mismatchCoount = 0;
        for (int i=0; i<heightsCopy.length; i++) {
            if (heightsCopy[i] != heights[i]) {
                mismatchCoount++;
            }
        }
        System.out.println("checked " + Arrays.toString(heights) + " mismatchCount " + mismatchCoount);
    }
}
