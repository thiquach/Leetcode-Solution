package main.java.com.leetcode;

import java.util.Arrays;
// 867
public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = transpose(matrix);
        System.out.println(" transpose " + Arrays.deepToString(matrix));
        System.out.println(" to " + Arrays.deepToString(result));
    }

    public static int[][] transpose(int[][] matrix) {
        if (matrix == null)
            return new int[][] {};

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
