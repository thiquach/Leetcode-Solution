package main.java.com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class PickGifts {
    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        System.out.println("pick gifts " + pickGifts(gifts, k));
    }

    public static long pickGifts(int[] gifts, int k) {
        long result = 0L;

        PriorityQueue<Long> gQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (long gift : gifts) {
            gQueue.add(gift);
        }

        while (!gQueue.isEmpty() && k > 0) {
            long gift = gQueue.poll();

            long sqrtGift = (long) Math.floor(Math.sqrt(gift));
            gQueue.add(sqrtGift);
            k--;
        }

        while (!gQueue.isEmpty()) {
            result += gQueue.poll();
        }
        return result;
    }
}