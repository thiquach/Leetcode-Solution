package main.java.com.leetcode;
// 2220 bit manipulation 
public class MinFlipBits {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        System.out.println("minBitFlips " + start + "->" + goal + " " + minBitFlips(start, goal));
    }

    public static int minBitFlips(int start, int goal) {
        if (goal == 0 && start == 0)
            return 0;

        int count = 0;
        while (start > 0 || goal > 0) {
            if (((start & 1) ^ (goal & 1)) == 1) {
                count++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return count;
    }
}