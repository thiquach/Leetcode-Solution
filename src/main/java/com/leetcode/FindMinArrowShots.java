package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static void main(String[] args) {
//        int[][] intervals = {{1,100}, {11,22}, {1,11}, {2,12}};
//        int[][] intervals = {{10,16}, {2,8}, {1,6}, {7,12}};
//        int[][] intervals = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] intervals = {{1,2},{2,3},{3,4},{4,5}};
        int[][] intervals = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int result = findMinArrowShots(intervals);
        System.out.println(" findMinArrowShots " +  result);
    }
    public static int findMinArrowShots(int[][] points) {
        int len = points.length;

        if (len < 1)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int arrowCount = 1;
        int prev = 0;

        for (int i=1; i<len; i++) {
            if (points[i][0] > points[prev][1]) {
                arrowCount++;
                prev = i;
            }
        }

        return arrowCount;
    }
}
