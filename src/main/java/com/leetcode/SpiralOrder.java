package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(" SpiralOrder " + Arrays.deepToString(matrix));
        System.out.println(" to " + result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null)
            return result;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int down = rows -1;
        int left = 0;
        int right = columns - 1;
        int dir = 0;

        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i=top; i<=right; i++) {
                    result.add(matrix[top][i]);
                }
                top = top + 1;
            } else if (dir == 1) {
                for (int i=top; i<=down; i++) {
                    result.add(matrix[i][right]);
                }
                right = right - 1;
            } else if (dir == 2) {
                for (int i=right; i>=left; i--) {
                    result.add(matrix[down][i]);
                }
                down = down - 1;
            } else if (dir == 3) {
                for (int i=down; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left = left + 1;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }
}