package main.java.com.leetcode;

import java.util.Arrays;

public class MaxChunksToSorted {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        System.out.println("max to sorted " + maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxNum = 0;
        int chunks = 0;
        for (int i=0; i<arr.length; i++) {
            if (maxNum < arr[i]) {
                maxNum = arr[i];
            }
            if (maxNum == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
