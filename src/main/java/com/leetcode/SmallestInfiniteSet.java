package main.java.com.leetcode;

import java.util.*;

// 2336 Heap Priority Queue
public class SmallestInfiniteSet {
    private TreeSet<Integer> numbersSet;

    public SmallestInfiniteSet() {
        numbersSet = new TreeSet<>();
        for (int i = 1; i < 1001; i++) {
            numbersSet.add(i);
        }
    }

    public int popSmallest() {
        int smallest = 0;
        if (!numbersSet.isEmpty()) {
            smallest = numbersSet.pollFirst();
        }
        return smallest;
    }

    public void addBack(int num) {
        if (num > 0 && num <= 1000) {
            numbersSet.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet s = new SmallestInfiniteSet();
        s.addBack(2);
        System.out.println(s.popSmallest()); // 1
        System.out.println(s.popSmallest()); // 2
        System.out.println(s.popSmallest()); // 3
    }
}