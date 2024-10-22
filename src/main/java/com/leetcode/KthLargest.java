package main.java.com.leetcode;

import java.util.*;

// 703
public class KthLargest {
    private PriorityQueue<Integer> pQueue;
    private int kthValue = 0;

    // add into pQueue k items. Pop small items for bigger items
    public KthLargest(int k, int[] nums) {
        pQueue = new PriorityQueue<>(k);

        for (int num: nums) {
            if (pQueue.size() < k) {
                pQueue.offer(num);
            } else if (num > pQueue.peek()) {
                pQueue.offer(num);
                if (pQueue.size() > k) {
                    pQueue.poll();
                }
            }
        }
        kthValue = k;
    }

    public int add(int val) {
        if (pQueue.size() < kthValue) {
            pQueue.offer(val);
        } else if (val > pQueue.peek()) {
            pQueue.offer(val);
            pQueue.poll();
        }
        return pQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
//        [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
//        int[] nums = {7, 7, 7, 7, 8, 3};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
        System.out.println(" add 3 -> " + kthLargest.add(3));
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
        System.out.println(" add 5 -> " + kthLargest.add(5));
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
        System.out.println(" add 10 -> " + kthLargest.add(10));
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
        System.out.println(" add 9 -> " + kthLargest.add(9));
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
        System.out.println(" add 4 -> " + kthLargest.add(4));
        System.out.print(" # " + kthLargest.pQueue.size() + " " + kthLargest.pQueue);
    }
}