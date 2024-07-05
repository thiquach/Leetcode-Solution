package main.java.com.leetcode;

import java.util.*;

public class EqualPairs {

    public static void main(String[] args) {
        int[][] grid = {{3,2,1}, {1,7,6}, {2, 7, 7}};
        System.out.println("\nEqualPairs" + Arrays.toString(grid[0]));
//
        System.out.println("count " + equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (compareRowWithColumn(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean compareRowWithColumn(int[][] grid, int row, int col) {

        int size = grid.length;

        for (int k=0; k<size; k++) {
            if (grid[row][k] != grid[k][col]) {
                return false;
            }
        }
        return true;
    }
}