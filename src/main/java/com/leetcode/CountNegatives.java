package main.java.com.leetcode;

public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2}, {-1,-1,-2,-3}};
        System.out.println(" count -ve " + countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        if (grid == null)
            return 0;

        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
