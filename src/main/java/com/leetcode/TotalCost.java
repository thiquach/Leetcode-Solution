package main.java.com.leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class TotalCost {
    public static void main(String[] args) {
//        int[] costs = new int[] {17,12,10,2,7,2,11,20,8};
        int[] costs = new int[] {1,2,4,1};
        int k = 3;
        int candidates = 3;
        System.out.println(" total cost " + totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        if (len == 0 || candidates > len)
            return 0;

        PriorityQueue<Integer> frontQ = new PriorityQueue<>();
        PriorityQueue<Integer> backQ = new PriorityQueue<>();

        int start = 0;
        int end = len - 1;
        long totalCost = 0L;
        for (int i=0; i<k; i++) {
            while (frontQ.size() < candidates && start <= end) {
                frontQ.add(costs[start]);
                start++;
            }
            while (backQ.size() < candidates && start <= end) {
                backQ.add(costs[end]);
                end--;
            }
            int f = !frontQ.isEmpty() ? frontQ.peek() : Integer.MAX_VALUE;
            int b = !backQ.isEmpty() ? backQ.peek() : Integer.MAX_VALUE;
            if (f <= b) {
                totalCost += f;
                frontQ.poll();
            } else {
                totalCost += b;
                backQ.poll();
            }
//            System.out.println(" f " + f + " b " + b + " total " + totalCost);
        }
        return totalCost;
    }
}