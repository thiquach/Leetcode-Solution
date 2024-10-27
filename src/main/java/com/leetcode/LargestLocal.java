package main.java.com.leetcode;

import java.util.Arrays;

public class LargestLocal {
    public static void main(String[] args) {

        int[][] grid = new int[][] {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] resultGrid = largestLocal(grid);
        System.out.print("LargestLocal ");
        for (int i=0; i<resultGrid.length; i++) {
            System.out.print(" " + Arrays.toString(resultGrid[i]) + " ");
        }
    }

    public static int[][] largestLocal(int[][] grid) {
        if (grid == null || grid.length < 3)
            return new int[][] {};

        int row = grid.length;
        int col = grid[0].length;
        int localRow = row - 2;
        int localCol = col - 2;
        int[][] localGrid = new int [localRow][localCol];

        for (int i=0; i<localRow; i++) {
            for (int j=0; j<localCol; j++) {
                localGrid[i][j] = maxValue(grid, i, j);
            }
        }
        return localGrid;
    }

    private static int maxValue(int[][] grid, int iStart, int jStart) {
        if (grid.length == 0)
            return 0;

        int result = 0;
        for (int i=iStart; i<3+iStart; i++) {
            for (int j=jStart; j<jStart+3; j++) {
                result = Math.max(result, grid[i][j]);
            }
        }
        return result;
    }
}