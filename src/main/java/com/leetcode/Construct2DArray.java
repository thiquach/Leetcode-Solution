package main.java.com.leetcode;

import java.util.Arrays;

// 2022
public class Construct2DArray {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int row = 1;
        int col = 1;
        System.out.println(" nums " + Arrays.toString(nums) + " " + row + " rows " + col + " cols");
        int[][] result = construct2DArray(nums,row, col);
        System.out.println(" construct2DArray? " + Arrays.deepToString(result));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || m * n != original.length)
            return new int [][] {};

        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }
        return result;
    }
}
