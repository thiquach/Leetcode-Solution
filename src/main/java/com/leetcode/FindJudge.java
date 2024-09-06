package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 997 graph - easy
public class FindJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,3},{1,4},{2,3}};
        int n = 4;
        int result = findJudge(n, trust);
        System.out.println("\nFindJudge: " + Arrays.deepToString(trust));
        System.out.println(" result " + result);
    }
    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }

        int[] trustCount = new int[n+1];

        for (int[] t : trust) {
            trustCount[t[0]]--;  // Decrease trust count for the person who trusts someone
            trustCount[t[1]]++;  // Increase trust count for the person being trusted
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;  // The person is trusted by everyone else and doesn't trust anyone
            }
        }

        return -1;  // If no judge found
    }
}
