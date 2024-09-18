package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

// 1046 priority queue
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int [] {2,7,4,1,8,1};
        System.out.println("last stone weight " + lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones == null)
            return 0;

        Integer[] stoneArray = Arrays.stream(stones).boxed().toArray(Integer[]::new);
        Arrays.sort(stoneArray, Collections.reverseOrder());
        int len = stones.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pQueue.add(stone);
        }

        while (pQueue.size() > 1) {
            int stone1 = pQueue.poll();

            if (!pQueue.isEmpty()) {
                int stone2 = pQueue.poll();
                if (stone1 != stone2) {
                    pQueue.add(stone1 - stone2);
                }
            } else {
                pQueue.add(stone1);
            }
        }
        return pQueue.isEmpty() ? 0 : pQueue.poll();
    }
}
