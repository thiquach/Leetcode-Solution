package main.java.com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // Expected output: 1
        System.out.println(counter.ping(100));  // Expected output: 2
        System.out.println(counter.ping(3001)); // Expected output: 3
        System.out.println(counter.ping(3002)); // Expected output: 3
    }
}