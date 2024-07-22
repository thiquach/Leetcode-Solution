package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// 435 Intervals medium
// greedy - as many non-overlapping as possible, DP, sorting
public class EraseOverlapIntervals {
    public static void main(String[] args) {
//            int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
//        {{-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
            int[][] intervals = {{1,100}, {11,22}, {1,11}, {2,12}};
//            int[][] intervals = {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};

            int result = eraseOverlapIntervals(intervals);
            System.out.println(" overlapping interval " +  result);
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;

        if (len <= 1)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int nonOverlap = 1;
        int prev = 0;

        for (int i=1; i<len; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                nonOverlap++;
                prev = i;
            }
        }

        return len - nonOverlap;
    }
}
