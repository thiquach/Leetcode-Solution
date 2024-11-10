package main.java.com.leetcode;

// 3133
public class MinEnd {
    public static void main(String[] args) {
        int n = 2;
        int x = 7;
        long result = minEnd(n,x);
        System.out.println("min end " + result);
    }

    public static long minEnd(int n, int x) {
        if (n < 1)
            return 0L;

        long next = x;
        long result = 0;
        for (int i=0; i<n; i++) {
            next = (next | x);
            result = next;
            next++;
        }
        return result;
    }
}