package main.java.com.leetcode;

import java.util.*;

public class FindScore {
    public static void main(String[] args) {
//        int[] nums = {2,1,3,4,5,2};
        int[] nums = {2,5,6,6,10};
//        int[] nums = {2,3,5,1,3,2};
        System.out.println("find score " + findScore(nums));
    }

    public static long findScore(int[] nums) {
        if (nums.length < 1)
            return 0L;

        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Compare second elements if first elements are equal
            }
            return Integer.compare(a[0], b[0]); // Otherwise, compare first elements
        });
        for (int i=0; i<nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        System.out.println(" num " + Arrays.toString(nums));
        long score = 0L;
        while (!pq.isEmpty()) {
           int[] entry = pq.poll();
            System.out.print(" entry " + Arrays.toString(entry));
           if (!visited[entry[1]]) {
               System.out.println(" Sntry " + Arrays.toString(entry));
               score += entry[0];
               int index = entry[1];
               visited[index] = true;
               if (index > 0) {
                   visited[index - 1] = true;
               }
               if ((index + 1) < nums.length) {
                   visited[index + 1] = true;
               }
           }
            System.out.println(" score " + score);
        }

        return score;
    }
}