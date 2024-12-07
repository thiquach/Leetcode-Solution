package main.java.com.leetcode;

import java.util.Arrays;

public class MaxCount {
    public static void main(String[] args) {
        int[] banned = {11};
        int n = 7;
        int maxSum = 50;
        System.out.println("maxCount " + maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        if (banned.length > 10000 || n > 10000) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        Arrays.sort(banned);

        for (int i=1; i<=n; i++) {
            if (Arrays.binarySearch(banned, i) < 0) {
                count++;
                if (sum + i > maxSum) {
                    count--;
                    break;
                }
                sum += i;
            }
        }
        return count;
    }
}
