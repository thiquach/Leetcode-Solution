package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;
// 1380
public class LuckyNumbers {
    public static void main(String[] args) {
//        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
//        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[][] matrix = {{3,6},{7,1},{5,2},{4,8}};
        System.out.println(" lucky number " + luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        if (matrix == null)
            return null;

        int row = matrix.length;
        int col = matrix[0].length;
        int[] minRow = new int[row];
        for (int i = 0; i < row; i++) {
            minRow[i] = minOrMaxValue(matrix[i], 1);
        }

        int[][] transposedMatrix = transpose(matrix);
        int[] maxCol = new int[col];
        for (int i = 0; i < col; i++) {
            maxCol[i] = minOrMaxValue(transposedMatrix[i], 2);
        }

        return findLuckyNumber(minRow, maxCol);
    }

    private static int minOrMaxValue(int[] nums, int minOrMax) {
        int result = 0;
        result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (minOrMax == 1) {
                result = Math.min(result, nums[i]);
            } else if (minOrMax == 2) {
                result = Math.max(result, nums[i]);
            }
        }
        return result;
    }

    private static List<Integer> findLuckyNumber(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                }
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        if (matrix == null)
            return new int[][]{};

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}