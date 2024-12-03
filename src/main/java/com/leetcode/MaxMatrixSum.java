package main.java.com.leetcode;
// 1975
public class MaxMatrixSum {
    public static void main(String[] args) {
//        int[][] matrix = {{1,-1},{-1,1}};
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println("max matrix sum " + maxMatrixSum(matrix));
    }

    public static long maxMatrixSum(int[][] matrix) {
        if (matrix == null)
            return 0L;

        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        long sum = 0L;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int entry = matrix[i][j];
                int entryAbs = Math.abs(entry);
                if (entry < 0) {
                    count++;
                }
                min = Math.min(entryAbs, min);
                sum += entryAbs;
            }
        }
        if ((count % 2) != 0) {
            sum = sum - (min * 2);
        }
        return sum;
    }
}
