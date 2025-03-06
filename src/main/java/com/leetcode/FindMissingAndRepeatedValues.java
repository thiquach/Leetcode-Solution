package main.java.com.leetcode;

import java.util.*;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
//        int[][] grid = {{1, 3}, {2, 2}};
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
        System.out.println("Missing repeated " + Arrays.toString(findMissingAndRepeatedValues(grid)));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        if (grid == null)
            return new int[]{};

        int numLength = grid.length * grid.length;
        int total = numLength * (numLength + 1) / 2;

        Set<Integer> numsSet = new HashSet<>();
        int index = 0;
        int setSum = 0;
        int pSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                numsSet.add(grid[i][j]);
                pSum += grid[i][j];
                index++;
            }
        }

        List<Integer> list = new ArrayList<>(numsSet);
        for (int i = 0; i < list.size(); i++) {
            setSum += list.get(i);
        }
        return new int[]{pSum - setSum, total - setSum};
    }
}
